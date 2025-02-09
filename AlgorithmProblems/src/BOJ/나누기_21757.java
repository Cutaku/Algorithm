package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나누기_21757 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

        long[] dp = new long[4];
        dp[0] = 1;

        if (arr[n - 1] % 4 > 0) {
            System.out.println(0);
            return;
        }

        int q = arr[n - 1] / 4;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 3 * q) dp[3] += dp[2];
            if (arr[i] == 2 * q) dp[2] += dp[1];
            if (arr[i] == q) dp[1] += dp[0];
        }

        System.out.println(dp[3]);
    }
}