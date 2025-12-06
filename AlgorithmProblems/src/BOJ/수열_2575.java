package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 수열_2575 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (m < 4) {
            sb.append("1 ");
        } else {
            if (m % 3 == 1) sb.append(2 + (m - 4) / 3).append(" ");
            else if (m % 3 == 2) sb.append(1 + (m - 2) / 3).append(" ");
            else sb.append(m / 3).append(" ");
        }


        if (m == 1) {
            sb.append("1");
        } else {
            List<Integer> primes = new ArrayList<>();

            boolean[] isNotPrime = new boolean[1001];

            for (int i = 3; i < 1000; i += 2) {
                if (isNotPrime[i]) continue;

                primes.add(i);

                for (int j = 3; i * j < 1000; j += 2) {
                    isNotPrime[i * j] = true;
                }
            }

            int c = 0;

            while (m % 2 == 0) {
                c++;
                m /= 2;
            }

            c = (c + 1) / 2;

            for (int p : primes) {
                while (m % p == 0) {
                    c++;
                    m /= p;
                }
            }

            sb.append(m > 1 ? c + 1 : c);
        }

        System.out.println(sb);
    }
}