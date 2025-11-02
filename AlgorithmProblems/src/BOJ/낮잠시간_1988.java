package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낮잠시간_1988 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[n + 1][k + 1][2];

        br.readLine();

        for (int i = 2; i <= n; i++) {
            int a = Integer.parseInt(br.readLine());

            for (int j = 2; j <= Math.min(i, k); j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0],  dp[i - 1][j][1]);
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][1] + a, Math.max(dp[i - 2][j - 1][0],  dp[i - 2][j - 1][1]));
            }
        }

        System.out.println(Math.max(dp[n][k][0],  dp[n][k][1]));
    }
}