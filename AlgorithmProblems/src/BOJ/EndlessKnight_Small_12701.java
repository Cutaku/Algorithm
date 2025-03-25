package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EndlessKnight_Small_12701 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int mod = 10007;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int h, w, r;
        int[][] dp;

        for (int t = 1; t <= n; t++) {
            sb.append("Case #").append(t).append(": ");

            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            dp = new int[h][w];
            dp[0][0] = 1;

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());

                dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (dp[i][j] < 1) continue;

                    if (i + 1 < h && j + 2 < w && dp[i + 1][j + 2] > -1) {
                        dp[i + 1][j + 2] = (dp[i + 1][j + 2] + dp[i][j]) % mod;
                    }

                    if (i + 2 < h && j + 1 < w && dp[i + 2][j + 1] > -1) {
                        dp[i + 2][j + 1] = (dp[i + 2][j + 1] + dp[i][j]) % mod;
                    }
                }
            }

            sb.append(dp[h - 1][w - 1]).append("\n");
        }

        System.out.println(sb);
    }
}