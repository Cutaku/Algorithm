package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기_1285 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                coins[i] += (line.charAt(j) == 'T' ? 1 : 0) << j;
            }
        }

        int min = n * n;

        for (int i = 0; i < 1 << n; i++) {;
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int b = Integer.bitCount(coins[j] ^ i);
                sum += Math.min(b, n - b);
            }

            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}