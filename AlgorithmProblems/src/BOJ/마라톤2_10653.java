package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마라톤2_10653 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        k = Math.min(k, n - 2);

        int[][] point = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int[][] dp = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= Math.min(i - 1, k); j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int l = 0; l <= j; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - l - 1][j - l] + dist(point, i, i - l - 1));
                }
            }

            for (int j = Math.min(i - 1, k) + 1; j <= k; j++) {
                dp[i][j] = dp[i][j - 1];
            }
        }

        System.out.println(dp[n - 1][k]);
    }

    static int dist(int[][] point, int i, int j) {

        return Math.abs(point[i][0] - point[j][0]) + Math.abs(point[i][1] - point[j][1]);
    }
}