package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 약수게임_16894 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        int s = (int) Math.sqrt(n + 1);

        boolean[] isNotPrime = new boolean[s + 2];
        isNotPrime[2] = true;

        int count = 0;

        while (n % 2 == 0) {
            count++;
            n /= 2;
        }

        for (int i = 3; i <= s; i += 2) {
            if (isNotPrime[i]) continue;

            while (n % i == 0) {
                count++;
                n /= i;
            }

            for (int j = 2; i * j <= s; j++) {
                isNotPrime[i * j] = true;
            }
        }

        if (n > 1) count++;

        count = Math.max(count, 1);

        System.out.println(count == 2 ? "cubelover" : "koosaga");
    }
}