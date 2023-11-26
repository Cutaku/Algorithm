package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 장미_3343 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] numbers = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = numbers[0], a = numbers[1], b = numbers[2], c = numbers[3], d = numbers[4];

        double A = (double) b / (double) a;
        double C = (double) d / (double) c;

        if (A > C || (A == C && a > c)) {
            long t1 = a;
            long t2 = b;
            a = c;
            b = d;
            c = t1;
            d = t2;
        }

        long ca = (n + a - 1) / a;
        long cc = 0L;

        long flowers = ca * a;
        long cost = ca * b;

        long min = cost;

        Set<Long> set = new HashSet<>();

        while (true) {
            if (ca < 0 || cc < 0) break;

            if (flowers >= n) {
                if (!set.add(flowers)) break;

                min = Math.min(min, cost);

                flowers -= a;
                cost -= b;
                ca--;
            } else {
                flowers += c;
                cost += d;
                cc++;
            }
        }

        System.out.println(min);
    }
}