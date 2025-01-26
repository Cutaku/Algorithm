package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일위의원_1709 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        long r = n >> 1;
        r *= r;

        long a = 1L, b = n >> 1;
        long ans = n - 1;

        while (a <= b) {
            long c = a * a + b * b;

            if (c > r) {
                b--;
            } else if (c < r) {
                a++;
            } else {
                if (a < b) ans -= 2;
                else ans++;

                a++;
                b--;
            }
        }

        System.out.println(ans * 4);
    }
}