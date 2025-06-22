package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구슬굴리기_23317 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] pass = new int[n];
        long[][] dp = new long[n][n];

        Arrays.fill(pass, -1);
        dp[0][0] = 1;

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (pass[a] < 0) {
                pass[a] = b;
            } else if (pass[a] != b) {
                System.out.println(0);
                return;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int p = pass[i + 1];

            if (p < 0) {
                for (int j = 0; j <= i; j++) {
                    dp[i + 1][j] += dp[i][j];
                    dp[i + 1][j + 1] += dp[i][j];
                }
            } else {
                dp[i + 1][p] = dp[i][p];
                if (p > 0) dp[i + 1][p] += dp[i][p - 1];
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) ans += dp[n - 1][i];

        System.out.println(ans);
    }
}