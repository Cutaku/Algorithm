package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백룸_26259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] num = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());

        boolean[][] left = new boolean[n + 1][m + 1];
        boolean[][] up = new boolean[n + 1][m + 1];
        boolean[][] v = new boolean[n][m];

        if (x1 == x2 && y1 != y2) {
            if (y1 > y2) {
                int t = y1;
                y1 = y2;
                y2 = t;
            }

            for (int i = y1; i < y2; i++) up[x1][i] = true;
        } else if (x1 != x2 && y1 == y2) {
            if (x1 > x2) {
                int t = x1;
                x1 = x2;
                x2 = t;
            }

            for (int i = x1; i < x2; i++) left[i][y1] = true;
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);

        v[0][0] = true;
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) continue;

                dp[i][j] += num[i][j];

                if (i < n - 1 && !up[i + 1][j]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    v[i + 1][j] = true;
                }

                if (j < m - 1 && !left[i][j + 1]) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);
                    v[i][j + 1] = true;
                }
            }
        }

        if (dp[n - 1][m - 1] == Integer.MIN_VALUE) {
            System.out.println("Entity");
        } else {
            System.out.println(dp[n - 1][m - 1]);
        }
    }
}