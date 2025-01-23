package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 우주선만들기_15912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] weight = new long[n];
        long[] energy = new long[n];
        long[] dp = new long[n + 1];

        StringTokenizer wSt = new StringTokenizer(br.readLine());
        StringTokenizer eSt = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            weight[i - 1] = Long.parseLong(wSt.nextToken());
            energy[i - 1] = Long.parseLong(eSt.nextToken());

            dp[i] = Long.MAX_VALUE;
            long wMax = 0, eMax = 0;

            for (int j = i - 1; j >= 0; j--) {
                wMax = Math.max(wMax, weight[j]);
                eMax = Math.max(eMax, energy[j]);

                dp[i] = Math.min(dp[i], dp[j] + wMax * eMax);
            }
        }

        System.out.println(dp[n]);
    }
}