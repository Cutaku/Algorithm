package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gift_15795 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        long d = 1000000007;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= k; i++) dp[i] = 2 * dp[i - 1] % d;
        for (int i = k + 1; i <= n; i++) dp[i] = (2 * dp[i - 1] - dp[i - k - 1] + d) % d;

        System.out.println(dp[n]);
    }
}