package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수화폐_16400 {
    public static void main(String[] args) throws IOException {

        int d = 123456789;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> primes = new ArrayList<>();

        boolean[] isNotPrime = new boolean[n + 1];

        primes.add(2);

        for (int i = 3; i <= n; i += 2) {
            if (isNotPrime[i]) continue;

            primes.add(i);

            for (int j = 2; i * j <= n; j++) isNotPrime[i * j] = true;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < primes.size(); i++) {
            for (int j = primes.get(i); j <= n; j++) {
                dp[j] = (dp[j] + dp[j - primes.get(i)]) % d;
            }
        }

        System.out.println(dp[n]);
    }
}