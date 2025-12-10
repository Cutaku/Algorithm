package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XYZ문자열_1663 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());

        if (q == 1) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(length(n)[n - 1]);
        } else if (q == 2) {
            int n = Integer.parseInt(br.readLine());
            long k = Long.parseLong(br.readLine()) - 1;

            System.out.println(findKth(n, k, length(n)));
        } else {
            int n = Integer.parseInt(br.readLine());
            int idx = br.readLine().charAt(0) - 'X';

            System.out.println(count(n, idx));
        }
    }

    static char findKth(int n, long k, long[] length) {

        if (n == 1) {
            return 'X';
        } else if (n == 2) {
            return k == 0 ? 'Y' : 'Z';
        } else if (n == 3) {
            return k == 0 ? 'Z' : 'X';
        }

        if (k >= length[n - 4]) return findKth(n - 2, k - length[n - 4], length);
        else return findKth(n - 3, k, length);
    }

    static long[] length(int n) {

        long[] dp = new long[Math.max(n, 3)];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 2;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        return dp;
    }

    static long count(int n, int idx) {

        long[] cnt = new long[3];
        cnt[0] = 1;

        for (int i = 1; i < n; i++) {
            long[] tmp = new long[3];

            tmp[0] += cnt[2];
            tmp[1] += cnt[0];
            tmp[2] += cnt[0] + cnt[1];

            cnt = tmp;
        }

        return cnt[idx];
    }
}