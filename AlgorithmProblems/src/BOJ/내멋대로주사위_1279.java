package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내멋대로주사위_1279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d = 1000000007;

        int m = Integer.parseInt(br.readLine());

        if (m < 4) {
            System.out.println(0);
            return;
        }

        int n = m * 6 - 21;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= 6; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
                dp[j] %= d;
            }
        }

        long ans = 0;

        for (int i = 0; i <= n; i++) {
            ans += dp[i];
            ans %= d;
        }

        System.out.println(ans * 30 % d);
    }
}