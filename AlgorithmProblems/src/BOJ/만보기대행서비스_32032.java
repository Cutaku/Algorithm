package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 만보기대행서비스_32032 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if (min >= 0) {
            System.out.println(2 * max + d);
            return;
        } else if (max <= 0) {
            System.out.println(2 * -min + d);
            return;
        }

        long ans = 2 * max - 2 * min + d + Math.min(d, 2 * Math.min(max, -min));

        if (2 * max - 2 * min <= d) {
            ans = 2 * max - 2 * min + d;
        } else {
            ans = Math.min(ans, 4 * max - 4 * min);
        }

        System.out.println(ans);
    }
}