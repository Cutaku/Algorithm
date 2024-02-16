package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class My뷰꾸미기_25569 {
    static int p = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] factorial = new long[600001];
        factorial[0] = 1;

        for (int i = 1; i <= 600000; i++) {
            factorial[i] = factorial[i - 1] * i % p;
        }

        int n = Integer.parseInt(br.readLine());

        long ans = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            long temp = factorial[a + b];
            temp = temp * findInverse(factorial[a]) % p;
            temp = temp * findInverse(factorial[b]) % p;
            temp--;

            ans = ans * temp % p;
        }

        System.out.println(ans);
    }

    static long findInverse(long n) {

        int d = p - 2;

        long res = 1;

        while (d > 0) {
            if (d % 2 == 1) {
                res = res * n % p;
                d--;
            } else {
                n = n * n % p;
                d /= 2;
            }
        }

        return res;
    }
}