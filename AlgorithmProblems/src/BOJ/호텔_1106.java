package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호텔_1106 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 1];

        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()), value = Integer.parseInt(st.nextToken());

            for (int j = 0; j < Math.min(value, c + 1); j++) {
                dp[j] = Math.min(dp[j], cost);
            }

            for (int j = value; j <= c; j++) {
                dp[j] = Math.min(dp[j], dp[j - value] + cost);
            }
        }

        System.out.println(dp[c]);
    }
}