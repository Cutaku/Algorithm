package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakingChange_6220 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());

            for (int j = coin; j <= c; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        System.out.println(dp[c]);
    }
}