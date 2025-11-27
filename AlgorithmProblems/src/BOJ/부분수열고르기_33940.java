package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열고르기_33940 {
    static int n;
    static long a, d, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        for (long l = n; l > 0; l--) {
            long q = check(l);

            if (q == -1) continue;

            long x = q / l;
            long y = q % l;
            a += x * d;

            StringBuilder sb = new StringBuilder();

            sb.append(l).append("\n");

            for (long i = 0; i < l - y; i++) {
                sb.append(a).append(" ");
                a += d;
            }

            a += d;

            for (long i = l - y; i < l; i++) {
                sb.append(a).append(" ");
                a += d;
            }

            System.out.println(sb);
            return;
        }

        System.out.println(-1);
    }

    static long check(long l) {

        long r = m - a * l;

        if (r < 0 || r % d > 0) return -1;

        long q = r / d - l * (l - 1) / 2;

        if (q < 0 || q > l * (n - l)) return -1;
        else return q;
    }
}