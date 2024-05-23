package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공약수_2436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int n = lcm / gcd;

        int a = 1, b = 1;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0 && gcd(i, n / i) == 1) {
                a = i;
                b = n / i;
            }
        }

        System.out.println(a * gcd + " " + b * gcd);
    }

    static int gcd(int a, int b) {

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}