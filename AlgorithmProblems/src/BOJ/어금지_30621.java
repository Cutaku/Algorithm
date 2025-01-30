package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어금지_30621 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer t = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());
        StringTokenizer c = new StringTokenizer(br.readLine());

        int[] time = new int[n + 1];
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            time[i] = Integer.parseInt(t.nextToken());

            int s = time[i] - Integer.parseInt(b.nextToken());
            int l = 0, r = i;

            while (r - l > 1) {
                int m = (l + r) / 2;

                if (time[m] < s) l = m;
                else r = m;
            }

            dp[i] = Math.max(dp[i - 1], dp[l] + Long.parseLong(c.nextToken()));
        }

        System.out.println(dp[n]);
    }
}