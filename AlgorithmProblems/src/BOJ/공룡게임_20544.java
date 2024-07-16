package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공룡게임_20544 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n + 1][2];

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;

        int d = 1000000007;

        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i - 3][0] + dp[i - 2][0] + dp[i - 1][0]) % d;
            dp[i][1] = (dp[i - 3][0] * 2 + dp[i - 3][1] * 3 + dp[i - 2][0] + dp[i - 2][1] * 2 + dp[i - 1][1]) % d;
        }

        System.out.println(dp[n][1]);
    }
}