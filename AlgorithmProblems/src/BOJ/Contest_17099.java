package BOJ;

import java.util.Arrays;
import java.util.Comparator;

public class Contest_17099 {
    public static void main(String[] args) throws Exception {

        int n = read();

        int[][] contests = new int[n][];
        for (int i = 0; i < n; i++) contests[i] = new int[]{read(), read(), read()};

        Arrays.sort(contests, Comparator.comparingInt(a -> a[1]));

        int[][] dp = new int[n + 1][];
        dp[0] = new int[]{-1, 0};

        int idx = 1;

        for (int i = 0; i < n; i++) {
            if (dp[idx - 1][0] < contests[i][0]) {
                dp[idx] = new int[]{contests[i][1], dp[idx++ - 1][1] + contests[i][2]};
                continue;
            }

            int s = 0, e = idx - 1;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (dp[m][0] < contests[i][0]) s = m;
                else e = m;
            }

            if (dp[idx - 1][1] >= dp[s][1] + contests[i][2]) continue;

            if (dp[idx - 1][0] == contests[i][1]) dp[idx - 1][1] = dp[s][1] + contests[i][2];
            else dp[idx++] =  new int[]{contests[i][1], dp[s][1] + contests[i][2]};
        }

        System.out.println(dp[idx - 1][1]);
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}