package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 거의소수_1456 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] ab = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = ab[0], b = ab[1];

        boolean[] prime = new boolean[10000001];
        Arrays.fill(prime, true);

        for (int i = 2; i <= 10000000; i++) {
            if (!prime[i]) continue;

            for (int j = 2; i * j <= 10000000; j++) {
                prime[i * j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= 10000000; i++) {
            if (prime[i]) primes.add(i);
        }

        long count = 0;

        for (int i = 0; i < primes.size(); i++) {
            long p = primes.get(i);
            double P = p * p;

            while ((P / b) <= 1) {
                if (P >= a) count++;

                P *= p;
            }
        }

        System.out.println(count);
    }
}