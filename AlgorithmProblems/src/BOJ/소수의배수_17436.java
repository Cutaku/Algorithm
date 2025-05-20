package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수의배수_17436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] primes = new long[(1 << (n - 1)) + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) primes[1 << i] = Long.parseLong(st.nextToken());

        long ans = 0;

        for (int i = 1; i < 1 << n; i++) {
            long d = 1;
            int idx = i;

            while (idx > 0) {
                int b = idx & -idx;
                idx -= b;
                d *= primes[b];
            }

            long c = m / d;

            ans += Integer.bitCount(i) % 2 == 0 ? -c : c;
        }

        System.out.println(ans);
    }
}