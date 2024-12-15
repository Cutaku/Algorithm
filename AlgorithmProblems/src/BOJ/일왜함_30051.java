package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일왜함_30051 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        int l = 50;

        String coin = br.readLine();

        long ans = 0;
        long start = 0;
        long p = 1;

        for (int i = 0; i < Math.min(n, l); i++) {
            start += p * (coin.charAt(i) - '1');

            long a = start == 0 ? 0 : 2 * p - start;

            if (a > t) {
                if (a > p && p > a - t) {
                    ans += Math.min(a - p, p - a + t);
                }
            } else {
                long b = t - a;

                ans += Math.max(0, a - p);
                ans += b / (2 * p) * p;
                ans += Math.max(0, b % (2 * p) - p);
            }

            p *= 2;
        }

         if (start + t - 1 >= 1L << l) {
            for (int i = l; i < n; i++) {
                if (coin.charAt(i) == '1') {
                    long d = (1L << l) - start;

                    ans += Math.min(d, t - d);
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}