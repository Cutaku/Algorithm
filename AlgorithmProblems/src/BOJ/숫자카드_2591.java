package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자카드_2591 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int l = input.length();

        long[] dp = new long[l + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= l; i++) {
            int num = input.charAt(i - 1) - '0';

            if (num > 0) dp[i] += dp[i - 1];

            num += 10 * (input.charAt(i - 2) - '0');

            if (9 < num && num < 35) dp[i] += dp[i - 2];
        }

        System.out.println(dp[l]);
    }
}