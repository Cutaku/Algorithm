package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버런_16117 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m + 1];
        for (int i = 0; i < n; i++) dp[i][1] = map[i][0];

        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                dp[i][j] += map[i][j];

                if (i > 0) dp[i - 1][j + 1] = Math.max(dp[i - 1][j + 1], dp[i][j]);
                if (i < n - 1) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                dp[i][j + 2] = Math.max(dp[i][j + 2], dp[i][j] + map[i][j + 1]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][m - 1] + map[i][m - 1]);
            max = Math.max(max, dp[i][m]);
        }

        dp = new int[n + 1][m + 1];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i <= n; i++) {
                if (i > 0) dp[i - 1][j + 1] = Math.max(dp[i - 1][j + 1], dp[i][j] + map[i - 1][j]);
                if (i < n) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + map[i][j]);
            }
        }

        for (int i = 0; i <= n; i++) {
            max = Math.max(max, dp[i][m]);
        }

        System.out.println(max);
    }
}