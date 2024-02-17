package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class 큰수만들기_16496 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        Arrays.sort(arr, (s1, s2) -> {
            if (s1.equals(s2)) return 0;

            int l1 = s1.length(), l2 = s2.length();

            for (int i = 0; i < l1 + l2; i++) {
                char c1 = s1.charAt(i % l1), c2 = s2.charAt(i % l2);
                if (c1 != c2) return c2 - c1;
            }

            return 0;
        });

        if (arr[0].equals("0")) {
            System.out.println(0);
            return;
        }

        for (String s : arr) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}