package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 불장난_14945 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 10007;

        int[][][] dp = new int[n][n][n];
        dp[1][0][1] = 2;

        for (int t = 1; t < n - 1; t++) {
            for (int i = 0; i < t; i++) {
                for (int j = i + 1; j <= t; j++) {
                    dp[t + 1][i][j] = (dp[t + 1][i][j] + dp[t][i][j]) % d;
                    dp[t + 1][i][j + 1] = (dp[t + 1][i][j + 1] + dp[t][i][j]) % d;
                    dp[t + 1][i + 1][j + 1] = (dp[t + 1][i + 1][j + 1] + dp[t][i][j]) % d;
                    if (i + 1 < j) dp[t + 1][i + 1][j] = (dp[t + 1][i + 1][j] + dp[t][i][j]) % d;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += dp[n - 1][i][j];
            }
        }

        System.out.println(ans % d);
    }
}