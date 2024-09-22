package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_16134 {
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        int q = n - r;

        long f = 1;
        long ans = 1;

        for (int i = 2; i <= n; i++) {
            f = (f * i) % d;

            if (i == r) ans = ans * power(f, d - 2) % d;
            if (i == q) ans = ans * power(f, d - 2) % d;
        }

        ans = ans * f % d;

        System.out.println(ans);
    }

    static long power(long f, int p) {

        long res = 1;

        while (p > 0)  {
            if (p % 2 == 0) {
                f = (f * f) % d;
                p >>= 1;
            } else {
                res = (res * f) % d;
                p--;
            }
        }

        return res;
    }
}