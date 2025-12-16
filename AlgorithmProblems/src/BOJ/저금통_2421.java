package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 저금통_2421 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[1000000];

        isPrime[2] = true;
        for (int i = 3; i < 1000000; i += 2) isPrime[i] = true;

        for (int i = 3; i < 1000; i += 2) {
            if (!isPrime[i]) continue;

            for (int j = i; i * j < 1000000; j += 2) {
                isPrime[i * j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                int max = 0;

                if (i < n) max = Math.max(max, dp[i + 1][j]);
                if (j < n) max = Math.max(max, dp[i][j + 1]);

                dp[i][j] = max + (isPrime[concat(i, j)] ? 1 : 0);
            }
        }

        System.out.println(dp[1][1] - 1);
    }

    static int concat(int a, int b) {

        if (b < 10) return 10 * a + b;
        else if (b < 100) return 100 * a + b;
        else return 1000 * a + b;
    }
}