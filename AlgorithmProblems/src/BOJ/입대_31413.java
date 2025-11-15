package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 입대_31413 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

        int t = m - sum[n];

        if (t <= 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE / 10);

        for (int i = 1; i <= n; i++) {
            int p = sum[i - 1] - sum[Math.min(n, i - 1 + d)] + a;

            if (p >= t) {
                System.out.println(1);
                return;
            }

            dp[0][i] = Math.max(dp[0][i - 1], p);

            for (int j = 1; j < i; j++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= d) dp[j][i] = Math.max(dp[j][i], dp[j - 1][i - d] + p);
            }
        }

        for (int i = 0; i < n; i++) {
            if (dp[i][n] >= t) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(-1);
    }
}