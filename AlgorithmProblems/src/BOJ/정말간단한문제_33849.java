package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정말간단한문제_33849 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        long[][] ratios = new long[n][];
        for (int i = 0; i < n; i++) {
            ratios[i] = new long[]{Long.parseLong(st1.nextToken()), Long.parseLong(st2.nextToken())};
        }

        long a = 1, b = 0;
        int c = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            long c1 = a * ratios[i][1];
            long c2 = b * ratios[i][0];

            if (c1 > c2) {
                c = 1;
                max = 1;
                a = ratios[i][0];
                b = ratios[i][1];
            } else if (c2 > c1) {
                c = 0;
            } else {
                max = Math.max(max, ++c);
            }
        }

        long gcd = gcd(a, b);

        System.out.print(b / gcd);
        System.out.print(" ");
        System.out.println(a / gcd);
        System.out.println(max);
    }

    static long gcd(long a, long b) {

        while (b > 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}