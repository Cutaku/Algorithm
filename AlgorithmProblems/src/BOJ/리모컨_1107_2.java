package BOJ;// 목표 채널로부터 하나씩 이동하며 숫자버튼으로 이동할 수 있는 채널인지 확인하는 방법

import java.io.*;
import java.util.*;

public class 리모컨_1107_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];

        if (m > 0) Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(b -> broken[b] = true);

        int d = Math.abs(n - 100);

        for (int i = 0; i < d; i++) {
            String str = String.valueOf(n + i);

            if (imp(broken, str)) continue;

            d = Math.min(d, str.length() + i);

            break;
        }

        for (int i = 1; i < d; i++) {
            if (n < i) break;

            String str = String.valueOf(n - i);

            if (imp(broken, str)) continue;

            d = Math.min(d, str.length() + i);

            break;
        }

        System.out.println(d);
    }

    static boolean imp(boolean[] broken, String str) {

        for (int i = 0; i < str.length(); i++) {
            if (broken[str.charAt(i) - '0']) return true;
        }

        return false;
    }
}