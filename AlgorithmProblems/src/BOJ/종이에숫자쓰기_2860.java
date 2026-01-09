package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이에숫자쓰기_2860 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("\\.");

        long integer = Long.parseLong(input[0]);
        long decimal = Long.parseLong(input[1]);

        long d = 1;
        for (int i = 0; i < input[1].length(); i++) d *= 10;

        long c = d / gcd(decimal, d);
        long a = integer * c + decimal * c / d;

        long[] ans = new long[6];
        int b = (int) (a / c);

        ans[b] = a % c;
        ans[b - 1] = c - ans[b];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        return  b == 0 ? a : gcd(b, a % b);
    }
}