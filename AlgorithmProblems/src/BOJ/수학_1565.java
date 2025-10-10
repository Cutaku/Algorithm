package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학_1565 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        long[] D = new long[d];
        long[] M = new long[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < d; i++) D[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) M[i] = Long.parseLong(st.nextToken());

        long g = gcd(M);

        long l = 1;

        for (int i = 0; i < d; i++) {
            l = lcm(l, D[i]);

            if (g % l > 0) {
                System.out.println(0);
                return;
            }
        }

        int r = (int) (g / l);
        int[] res = cnt(r, 2);

        r = res[0];
        long ans = res[1];

        int q = (int) Math.sqrt(r + 1);

        boolean[] isNotPrime = new boolean[q + 1];

        for (int i = 3; i <= q; i += 2) {
            if (isNotPrime[i]) continue;

            res = cnt(r, i);

            r = res[0];
            ans *= res[1];

            for (int j = 3; i * j <= q; j += 2) {
                isNotPrime[i * j] = true;
            }
        }

        System.out.println(r > 1 ? ans * 2 : ans);
    }

    static int[] cnt(int r, int p) {

        int[] res = new int[]{r, 1};

        while (res[0] % p == 0) {
            res[0] /= p;
            res[1]++;
        }

        return res;
    }

    static long lcm(long a, long b) {

        return a * b / gcd(a, b);
    }

    static long gcd(long[] a) {

        long res = a[0];

        for (int i = 1; i < a.length; i++) res = gcd(res, a[i]);

        return res;
    }

    static long gcd(long a, long b) {

        return b == 0 ? a : gcd(b, a % b);
    }
}