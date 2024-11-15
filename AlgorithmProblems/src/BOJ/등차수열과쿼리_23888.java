package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등차수열과쿼리_23888 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()), d = Long.parseLong(st.nextToken());

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            long c = r - l + 1;

            if (x == 1) {
                long sum = (a + (l - 1) * d) * c;
                sum += d * c * (c - 1) / 2;
                sb.append(sum).append("\n");
            } else {
                long s = a + (l - 1) * d;

                if (c > 1) s = gcd(s, d);

                sb.append(s).append("\n");
            }
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {

        while (b > 0) {
            long t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}