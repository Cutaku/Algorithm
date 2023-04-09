package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 소수의연속합_1644 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        int count = 0;

        int s = 2;
        int e = 2;
        int sum = 2;


        while (s <= n && e <= n) {
            if (sum == n) count++;

            if (sum < n) {
                do {
                    e++;
                } while (e <= n && !isPrime[e]);

                sum += e;
            } else {
                sum -= s;

                do {
                    s++;
                } while (s <= n && !isPrime[s]);
            }
        }

        System.out.println(count);
    }
}