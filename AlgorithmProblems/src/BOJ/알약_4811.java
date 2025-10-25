package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알약_4811 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 31; i++) {
            for (int j = 0; j < i; j++) dp[i] += dp[j] * dp[i - j - 1];
        }

        int n;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}