package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 말아톤_2327 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[] dp = new int[h + 1];
        dp[0] = 100001;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            for (int j = h; j >= a; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - a], b));
            }
        }

        System.out.println(dp[h]);
    }
}