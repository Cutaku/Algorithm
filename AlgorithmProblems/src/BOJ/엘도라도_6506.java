package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 엘도라도_6506 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        while (n > 0) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            long[][] dp = new long[n][k];

            arr[0] = Integer.parseInt(st.nextToken());
            dp[0][0] = 1;
            long ans = dp[0][k - 1];

            for (int i = 1; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i][0] = 1;

                for (int j = 0; j < i; j++) {
                    if (arr[i] <= arr[j]) continue;

                    for (int l = 0; l < k - 1; l++) {
                        if (dp[j][l] > 0) dp[i][l + 1] += dp[j][l];
                    }
                }

                ans +=  dp[i][k - 1];
            }

            sb.append(ans).append("\n");

            st =  new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}