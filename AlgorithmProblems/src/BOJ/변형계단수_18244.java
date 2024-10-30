package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 변형계단수_18244 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1000000007;

        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n + 1][10][4];

        if (n == 1) {
            System.out.println(10);
            return;
        }

        for (int i = 0; i < 9; i++) {
            dp[2][i][0]++;
            dp[2][i + 1][2]++;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < 9; j++) {
                dp[i][j][0] = (dp[i - 1][j + 1][2] + dp[i - 1][j + 1][3]) % d;
                dp[i][j][1] = dp[i - 1][j + 1][0];
                dp[i][j + 1][2] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % d;
                dp[i][j + 1][3] = dp[i - 1][j][2];
            }
        }

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                ans = (ans + dp[n][i][j]) % d;
            }
        }

        System.out.println(ans);
    }
}