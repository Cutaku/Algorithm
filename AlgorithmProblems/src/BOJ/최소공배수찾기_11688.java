package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최소공배수찾기_11688 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        long lcm = lcm(a, b);

        if (l % lcm > 0) {
            System.out.println(-1);
            return;
        }

        int x = (int) (l / lcm);

        System.out.println(l / findCoprime(l, x));
    }

    static int gcd(int a, int b) {

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    static long lcm(int a, int b) {

        int gcd = gcd(a, b);

        return (long) a * b / gcd;
    }

    static long findCoprime(long l, int x) {

        boolean[] isNotPrime = new boolean[x + 1];

        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        for (int i = 3; i <= x; i += 2) {
            if (!isNotPrime[i]) {
                primes.add(i);

                for (int j = 2; i * j <= x; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }

        for (int p : primes) {
            if (x % p == 0) {
                while (l % p == 0) l /= p;
            }
        }

        return l;
    }
}