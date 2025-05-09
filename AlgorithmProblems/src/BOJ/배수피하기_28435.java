package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배수피하기_28435 {
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        long[] count = new long[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) count[Integer.parseInt(st.nextToken()) % k]++;

        long ans = 1;

        for (int i = 0; i <= k / 2 ; i++) {
            if (i == k - i || i == 0) {
                ans = ans * (count[i] + 1) % d;
            } else {
                long b = (pow(count[i]) + pow(count[k - i]) - 1) % d;

                ans = ans * b % d;
            }
        }

        System.out.println((ans - n - 1 + d) % d);
    }

    static long pow(long p) {

        long res = 1;
        long a = 2;

        while (p > 0) {
            if (p % 2 == 0) {
                p /= 2;
                a = a * a % d;
            } else {
                p--;
                res = res * a % d;
            }
        }

        return res;
    }
}