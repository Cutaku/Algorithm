package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 떡파이어_15717 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        long d = 1000000007;
        long a = 2;
        long ans = 1;
        n--;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * a % d;
                n--;
            } else {
                a = a * a % d;
                n /= 2;
            }
        }

        System.out.println(ans);
    }
}