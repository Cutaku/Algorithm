package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 크리스마스선물_3131 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] prices = new long[n];
        for (int i = 0; i < n - 1; i++) prices[i] = Long.parseLong(br.readLine());

        long[] preSum = new long[n + 1];
        for (int i = n; i > 1; i--) preSum[i - 2] += prices[i - 2] + preSum[i];

        long last = Long.MAX_VALUE / 10;
        long sumA = 0, sumB = 0;

        prices[n - 1] = 1;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                long c = sumB - sumA + preSum[i] - preSum[i + 1];
                long min = Math.max(prices[i], c + a);
                long max = Math.min(last, c + b + 1);

                ans += Math.max(0, max - min);
                sumA += prices[i];
            } else {
                long c = sumA - sumB + preSum[i] - preSum[i + 1];
                long min = Math.max(prices[i], c - b);
                long max = Math.min(last, c - a + 1);

                ans += Math.max(0, max - min);
                sumB += prices[i];
            }

            last = prices[i];
        }

        System.out.println(ans);
    }
}