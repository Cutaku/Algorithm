package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전바꿔주기_2624 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[t + 1];
        dp[0] = 1;

        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

            for (int j = t; j > 0; j--) {
                for (int l = 1; l <= Math.min(n, j / p); l++) {
                    dp[j] += dp[j - l * p];
                }
            }
        }

        System.out.println(dp[t]);
    }
}