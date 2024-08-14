package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 수학은너무쉬워_2904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotPrime = new boolean[1000000];

        List<Integer> primes = new ArrayList<>();

        primes.add(2);

        for (int i = 3; i < 1000000; i += 2) {
            if (!isNotPrime[i]) {
                primes.add(i);

                for (int j = 2; i * j < 1000000; j++) {
                    isNotPrime[i * j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int res = 1;
        int count = 0;

        int[] power = new int[n];

        for (int p : primes) {
            int c = 0;

            Arrays.fill(power, 0);

            for (int i = 0; i < n; i++) {
                int m = arr[i];

                while (m % p == 0) {
                    m /= p;
                    c++;
                    power[i]++;
                }
            }

            c /= n;

            res *= (int) Math.pow(p, c);

            for (int i = 0; i < n; i++) {
                count += Math.max(0, c - power[i]);
            }
        }

        System.out.println(res + " " + count);
    }
}