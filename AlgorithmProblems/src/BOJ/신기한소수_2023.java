package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 신기한소수_2023 {
    static int n;
    static boolean[] isPrime;
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int m = (int) Math.pow(10, n);

        isPrime = new boolean[(int)Math.sqrt(m) + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        primes = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (isPrime[i]) {
                primes.add(i);

                for (int j = 2; j * i <= Math.sqrt(m); j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        findPrime(2, 1);
        findPrime(3, 1);
        findPrime(5, 1);
        findPrime(7, 1);
    }

    static boolean isPrime(int p) {
        if (p < isPrime.length) return isPrime[p];

        for (int prime : primes) {
            if (p % prime == 0) return false;
        }

        return true;
    }

    static void findPrime(int p, int l) {
        if (l == n) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            int np = p * 10 + i;

            if (isPrime(np)) findPrime(np, l + 1);
        }
    }
}