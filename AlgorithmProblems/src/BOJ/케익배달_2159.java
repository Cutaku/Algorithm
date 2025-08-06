package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케익배달_2159 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] locations = new int[n + 1][];

        for (int i = 0; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            locations[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        long[][] dp = new long[n + 1][5];
        for (int i = 1; i < 5; i++) dp[0][i] = 1;

        int[][] D = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = Long.MAX_VALUE;

                for (int k = 0; k < 5; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] +
                            dist(locations[i - 1][0] + D[k][0],
                                    locations[i - 1][1] + D[k][1],
                                    locations[i][0] + D[j][0],
                                    locations[i][1] + D[j][1])
                    );
                }

            }
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) ans = Math.min(ans, dp[n][i]);

        System.out.println(ans);
    }

    static int dist(int x1, int y1, int x2, int y2) {

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}