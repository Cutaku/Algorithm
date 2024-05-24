package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 네개의소수_1153 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n < 8) {
            System.out.println(-1);
            return;
        }

        List<Integer> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[n + 1];

        primes.add(2);

        for (int i = 3; i < n; i += 2) {
            if (notPrime[i]) continue;

            primes.add(i);

            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }

        if (n % 2 == 0) {
            System.out.print("2 2 ");
            n -= 4;
        } else {
            System.out.print("2 3 ");
            n -= 5;
        }

        int s = 0, e = primes.size() - 1;

        while (s <= e) {
            if (primes.get(s) + primes.get(e) < n) s++;
            else if (primes.get(s) + primes.get(e) > n) e--;
            else {
                System.out.println(primes.get(s) + " " + primes.get(e));
                return;
            }
        }
    }
}