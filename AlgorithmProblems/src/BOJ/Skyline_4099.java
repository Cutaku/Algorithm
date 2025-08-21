package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skyline_4099 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1001];

        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i < 1001; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }

            dp[i] %= 1000000L;
        }

        StringBuilder sb = new StringBuilder();

        int n;

        while ((n = Integer.parseInt(br.readLine())) > 0) {
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}