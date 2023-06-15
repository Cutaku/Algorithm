package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 책페이지_1019 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int l = input.length();

        int n = Integer.parseInt(input);

        long[] ans = new long[10];

        for (int i = 0; i < 10; i++) {
            long d = 1;

            for (int j = 1; j <= l; j++) {
                ans[i] += (n / d / 10) * d + Math.max(0, Math.min(d, n % (d * 10) - i * d + 1));
                d *= 10;
            }
        }

        long d = 1;
        for (int i = 0; i < l; i++) {
            ans[0] -= d;
            d *= 10;
        }

        for (long a : ans) {
            System.out.print(a + " ");
        }
    }
}