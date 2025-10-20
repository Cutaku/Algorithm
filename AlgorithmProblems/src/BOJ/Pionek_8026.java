package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pionek_8026 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken()) - 1, y1 = Long.parseLong(st.nextToken()) - 1;
        long x2 = Long.parseLong(st.nextToken()) - 1, y2 = Long.parseLong(st.nextToken()) - 1;

        long x = Long.parseLong(br.readLine());
        for (int i = 1; i < n; i++) x = gcd(x, Long.parseLong(br.readLine().trim()));

        long y = Long.parseLong(br.readLine());
        for (int i = 1; i < m; i++) y = gcd(y, Long.parseLong(br.readLine().trim()));

        long r = max(x2, x) - min(x1, x);
        long c = max(y2, y) - min(y1, y);

        if (r < 0) r = 0;
        else r = r / x + 1;

        if (c < 0) c = 0;
        else c = c / x + 1;

        System.out.println(r * c);
    }

    static long gcd(long a, long b){

        return b == 0 ? a : gcd(b, a % b);
    }

    static long min(long c, long a) {

        long res = (c / a) * a;

        return res < c ? res + a : res;
    }

    static long max(long c, long a) {

        long res = (c / a) * a;

        return res > c ? res - a : res;
    }
}