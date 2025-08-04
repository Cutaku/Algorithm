package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈게임_4370 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[16];

        arr[0] = 9;

        for (int i = 1; i < 15; i++) {
            if (i % 2 == 0) arr[i] = arr[i - 1] * 9;
            else arr[i] = arr[i - 1] * 2;
        }

        StringBuilder sb = new StringBuilder();

        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            if (n < 10) {
                sb.append("Baekjoon wins.\n");
                continue;
            }

            int s = 0, e = 15;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (arr[m] < n) s = m;
                else e = m;
            }

            sb.append(e % 2 == 0 ? "Baekjoon wins.\n" : "Donghyuk wins.\n");
        }

        System.out.println(sb);
    }
}