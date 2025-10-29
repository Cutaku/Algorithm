package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NIKOLA_2976 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) cost[i] = Integer.parseInt(br.readLine());

        int max = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], max);

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == max) continue;

                if (i <= j) dp[i][j - i] = Math.min(dp[i][j - i], dp[i][j] + cost[j - i]);
                if (j + i + 1 < n) dp[i + 1][j + i + 1] = Math.min(dp[i + 1][j + i + 1], dp[i][j] + cost[j + i + 1]);
            }
        }

        int min = max;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[i][n - 1]);
        }

        System.out.println(min);
    }
}