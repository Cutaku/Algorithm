package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ControlledInflation_25097 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("Case #").append(t).append(": ");

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());

            int[][] minMax = new int[n + 1][2];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());

                minMax[i][0] = 1000000001;

                for (int j = 0; j < p; j++) {
                    int x = Integer.parseInt(st.nextToken());

                    minMax[i][0] = Math.min(minMax[i][0], x);
                    minMax[i][1] = Math.max(minMax[i][1], x);
                }
            }

            long[][] dp = new long[n + 1][2];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0] + Math.abs(minMax[i - 1][0] - minMax[i][1]),
                        dp[i - 1][1] + Math.abs(minMax[i - 1][1] - minMax[i][1])) + minMax[i][1] - minMax[i][0];

                dp[i][1] = Math.min(dp[i - 1][0] + Math.abs(minMax[i - 1][0] - minMax[i][0]),
                        dp[i - 1][1] + Math.abs(minMax[i - 1][1] - minMax[i][0])) + minMax[i][1] - minMax[i][0];
            }

            sb.append(Math.min(dp[n][0], dp[n][1])).append("\n");
        }

        System.out.println(sb);
    }
}