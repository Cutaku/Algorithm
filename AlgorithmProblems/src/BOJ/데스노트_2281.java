package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 데스노트_2281 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] names = new int[n];
        for (int i = 0; i < n; i++) names[i] = Integer.parseInt(br.readLine());

        int l = n - 1;
        int last = -1;

        while (l >= 0 && last <= m) last += names[l--] + 1;

        if (last <= m) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int sum = names[i];
            dp[i + 1] = dp[i] + (m - sum) * (m - sum);

            for (int j = i - 1; j >= 0; j--) {
                sum += names[j] + 1;

                if (sum > m) break;

                dp[i + 1] = Math.min(dp[i + 1], dp[j] + (m - sum) * (m - sum));
            }

            if (i > l) ans = Math.min(ans, dp[i + 1]);
        }

        System.out.println(ans);
    }
}