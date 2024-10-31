package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 토너먼트만들기_2262 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rank = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) rank[i] = Integer.parseInt(st.nextToken());

        int[][] min = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int m = rank[i];

            for (int j = i; j < n; j++) {
                m = Math.min(m, rank[j]);
                min[i][j] = m;
            }

            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                for (int j = 0; j < d; j++) {
                    dp[i][i + d] = Math.min(dp[i][i + d],
                            Math.abs(min[i][i + j] - min[i + j + 1][i + d]) + dp[i][i + j] + dp[i + j + 1][i + d]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}