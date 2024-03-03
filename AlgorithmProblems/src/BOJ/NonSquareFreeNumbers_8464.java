package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NonSquareFreeNumbers_8464 {
    static List<Integer> primes;
    static int max = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        findPrimes();

        long k = Long.parseLong(br.readLine());

        long s = 0;
        long e = 26000000000L;

        while (e - s > 1) {
            long m = (s + e) / 2;

            if (countNonSquareFree(1, 0, m, Math.sqrt(m), true) >= k) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static long countNonSquareFree(long acc, int s, long k, double rK, boolean isOdd) {

        long res = 0;

        for (int i = s; i < primes.size(); i++) {
            long nAcc = acc * primes.get(i);
            if (nAcc > rK) break;

            long count = k / nAcc / nAcc;
            res += countNonSquareFree(nAcc,i + 1, k, rK, !isOdd) + (isOdd ? count : -count);
        }

        return res;
    }

    static void findPrimes() {

        primes = new ArrayList<>();

        boolean[] isNotPrime = new boolean[max];

        primes.add(2);

        for (int i = 3; i < max; i += 2) {
            if (isNotPrime[i]) continue;

            primes.add(i);

            for (int j = 3; i * j < max; j += 2) {
                isNotPrime[i * j] = true;
            }
        }
    }
}