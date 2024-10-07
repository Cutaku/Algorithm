package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrunkPassenger_23337 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[] dp = new double[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] += 1.0;

            for (int j = 2; j < i; j++) {
                dp[i] += 1.0 * (j - 1) / j * dp[j];
            }

            dp[i] /= i - 1;
        }

        System.out.println(dp[n]);
    }
}