package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열탈출_11909 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 10);
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + Math.max(0, map[i][j] - map[i][j - 1] + 1));
                if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + Math.max(0, map[i][j] - map[i - 1][j] + 1));
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}