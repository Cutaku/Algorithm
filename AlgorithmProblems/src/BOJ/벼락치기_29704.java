package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벼락치기_29704 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        int[] dp = new int[t + 1];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            sum += m;

            for (int j = t; j >= d; j--) {
                dp[j] = Math.max(dp[j], dp[j - d] + m);
            }
        }

        System.out.println(sum - dp[t]);
    }
}