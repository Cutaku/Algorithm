package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사수빈탕_14585 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[301][301];

        int mx = 0, my = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            if (x + y < m) {
                mx = Math.max(x, mx);
                my = Math.max(y, my);
                dp[x][y] = m - x - y;
            }
        }

        for (int i = 0; i <= mx; i++) {
            for (int j = 0; j <= my; j++) {
                int max = 0;

                if (i > 0) max = Math.max(max, dp[i - 1][j]);
                if (j > 0) max = Math.max(max, dp[i][j - 1]);

                dp[i][j] += max;
            }
        }

        System.out.println(dp[mx][my]);
    }
}