package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달려달려_1757 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            int d = Integer.parseInt(br.readLine());

            dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);

            for (int j = 1; j <= Math.min(m, i); j++) {
                dp[i][j] = dp[i - 1][j - 1] + d;
                if (i + j <= n) dp[i + j][0] = Math.max(dp[i + j][0], dp[i][j]);
            }
        }

        System.out.println(dp[n][0]);
    }
}