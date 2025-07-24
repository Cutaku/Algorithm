package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크리보드_11058 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i < n) dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);

            for (int j = 3; i + j <= n; j++) {
                dp[i + j] = Math.max(dp[i + j], (j - 1) * dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}