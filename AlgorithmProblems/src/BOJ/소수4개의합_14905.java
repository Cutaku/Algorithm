package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소수4개의합_14905 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;

        boolean[] isNotPrime = new boolean[100000000];
        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        for (int i = 3; i < 100000000; i += 2) {
            if (isNotPrime[i]) continue;

            primes.add(i);

            for (int j = 3; i * j < 100000000; j += 2) {
                isNotPrime[i * j] = true;
            }
        }

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            if (n < 8) {
                sb.append("Impossible.\n");
                continue;
            }

            sb.append("2 ");
            n -= 2;

            if (n % 2 == 1) {
                sb.append("3 ");
                n -= 3;
            } else {
                sb.append("2 ");
                n -= 2;
            }

            int s = 0, e = primes.size();

            while (e - s > 1) {
                int m = (s + e) / 2;

                if (primes.get(m) >= n) e = m;
                else s = m;
            }

            int l = 0, r = s;
            boolean pos = false;

            while (l <= r) {
                if (primes.get(l) + primes.get(r) < n) {
                    l++;
                } else if (primes.get(l) + primes.get(r) > n) {
                    r--;
                } else {
                    pos = true;
                    sb.append(primes.get(l)).append(" ").append(primes.get(r)).append("\n");
                    break;
                }
            }

            if (!pos) sb.append("Impossible.\n");
        }

        System.out.println(sb);
    }
}