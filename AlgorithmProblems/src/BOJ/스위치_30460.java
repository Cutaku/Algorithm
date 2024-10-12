package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치_30460 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 2];

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1] + arr[2], 2 * (dp[1] + arr[2]));

        for (int i = 3; i < n + 2; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], dp[i - 3] + 2 * (arr[i - 2] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[n + 1]);
    }
}