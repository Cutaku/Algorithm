package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오렌지출하_11985 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(br.readLine());

        long[][] price = new long[n + 1][m];

        for (int i = 1; i <= n; i++) {
            long min = arr[i - 1];
            long max = arr[i - 1];

            for (int j = 0; j < m && i + j <= n; j++) {
                min = Math.min(min, arr[i + j - 1]);
                max = Math.max(max, arr[i + j - 1]);

                price[i + j][j] = k + (j + 1) * (max - min);
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < Math.min(m, i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j - 1] + price[i][j]);
            }
        }

        System.out.println(dp[n]);
    }
}