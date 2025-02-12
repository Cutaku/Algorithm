package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SplitTheGSHS2_31748 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 1000000007;

        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        dp[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i + arr[i] <= n) dp[i + arr[i]] = (dp[i + arr[i]] + dp[i - 1]) % d;
            if (i - arr[i] > 0 && arr[i] != arr[i - arr[i]]) dp[i] = (dp[i] + dp[i - arr[i] - 1]) % d;
        }

        System.out.println(dp[n]);
    }
}