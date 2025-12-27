package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 등비수열의합_23848 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (long p = 2; p < n; p++) {
            long d = 1 + p + p * p;
            int c = 3;

            if (d > n) break;

            while (d <= n) {
                if (n % d == 0) {
                    long b = n / d;
                    sb.append(c).append("\n");

                    for (int i = 0; i < c; i++) {
                        sb.append(b).append(" ");
                        b *= p;
                    }

                    System.out.println(sb);
                    return;
                }

                c++;
                d = d * p + 1;
            }
        }

        System.out.println(-1);
    }
}