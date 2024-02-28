package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프_1890 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int jump = Integer.parseInt(st.nextToken());

                if (jump == 0) break;

                if (j + jump < n) dp[i][j + jump] += dp[i][j];
                if (i + jump < n) dp[i + jump][j] += dp[i][j];
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}