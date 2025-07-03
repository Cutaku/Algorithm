package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 함께블록쌓기_18427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int d = 10007;

        int[] dp = new int[h + 1];
        dp[0] = 1;

        int[] block = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int idx = 0;
            while (st.hasMoreTokens()) block[idx++] = Integer.parseInt(st.nextToken());

            for (int j = h; j >= 0; j--) {
                if (dp[j] > 0) {
                    for (int k = 0; k < idx; k++) {
                        if (j + block[k] <= h) dp[j + block[k]] = (dp[j + block[k]] + dp[j]) % d;
                    }
                }
            }
        }

        System.out.println(dp[h]);
    }
}