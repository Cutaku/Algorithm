package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수확_1823 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i][i] = n * arr[i];
        }

        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                dp[i][i + d] = Math.max(dp[i][i + d - 1] + (n - d) * arr[i + d], dp[i + 1][i + d] + (n - d) * arr[i]);
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}