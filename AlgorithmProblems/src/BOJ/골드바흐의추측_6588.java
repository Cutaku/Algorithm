package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 골드바흐의추측_6588 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[1000001];

        List<Integer> primes = new ArrayList<>();

        for (int i = 3; i < 500000; i += 2) {
            if (isPrime[i]) continue;

            primes.add(i);

            for (int j = 2; i * j <= 1000000 ; j++) {
                isPrime[i * j] = false;
            }
        }

        int n;

        a: while ((n = Integer.parseInt(br.readLine())) > 0) {

            for (int prime : primes) {
                if (isPrime[n - prime]) {
                    sb.append(n).append(" = ").append(prime).append(" + ").append(n - prime).append("\n");
                    continue a;
                }
            }

            sb.append("Goldbach's conjecture is wrong\n");
        }

        System.out.println(sb);
    }
}