package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpellCards_28467 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            int m = arr[i];

            for (int j = i; j < n; j++) {
                m = Math.max(m, arr[j]);
                max[i][j] = m;
            }
        }

        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                for (int j = i; j < i + d; j++) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][j] + dp[j + 1][i + d] + max[i][j] + max[j + 1][i + d]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}