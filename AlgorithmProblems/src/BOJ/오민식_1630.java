package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오민식_1630 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long p = 1;
        long d = 987654321;

        while (2 * p <= n) p *= 2;

        long ans = p;

        boolean[] isNotPrime = new boolean[n + 1];

        for (int i = 3; i <= n; i += 2) {
            if (isNotPrime[i]) continue;

            for (int j = 3; i * j <= n; j += 2) isNotPrime[i * j] = true;

            p = 1;
            while (p * i <= n) p *= i;

            ans = ans * p % d;
        }

        System.out.println(ans);
    }
}