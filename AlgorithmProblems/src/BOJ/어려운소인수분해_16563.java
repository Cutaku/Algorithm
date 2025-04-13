package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 어려운소인수분해_16563 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        boolean[] isNotPrime = new boolean[5000000];

        for (int i = 3; i * i < 5000000; i += 2) {
            if (isNotPrime[i]) continue;

            primes.add(i);

            for (int j = 3; i * j < 5000000; j += 2) {
                isNotPrime[i * j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            for (int p : primes) {
                if (p * p > k) break;

                while (k % p == 0) {
                    sb.append(p).append(" ");
                    k /= p;
                }

                if (k == 1) break;
            }

            if (k > 1) sb.append(k);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}