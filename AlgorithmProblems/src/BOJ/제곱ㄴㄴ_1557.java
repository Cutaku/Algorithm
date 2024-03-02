package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 제곱ㄴㄴ_1557 {
    static List<Integer> primes;
    static int max = (int) Math.sqrt(Integer.MAX_VALUE);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        findPrimes();

        int k = Integer.parseInt(br.readLine());

        long s = k - 1;
        long e = Integer.MAX_VALUE;

        while (e - s > 1) {
            long m = (s + e) / 2;

            if (countSquareFree((int) m) >= k) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static int countSquareFree(int k) {
        return k - dfs(1, 0, k, Math.sqrt(k), true);
    }

    static int dfs(int acc, int s, int k, double rK, boolean isOdd) {

        int res = 0;

        for (int i = s; i < primes.size(); i++) {
            int nAcc = acc * primes.get(i);
            if (nAcc > rK) break;

            int count = k / nAcc / nAcc;
            res += dfs(nAcc,i + 1, k, rK, !isOdd) + (isOdd ? count : -count);
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