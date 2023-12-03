package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 제곱ㄴㄴ수_1016 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] minMax = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long min = minMax[0], max = minMax[1];

        int d = (int) (max - min);

        boolean[] filter = new boolean[(int) Math.sqrt(max) + 1];
        Arrays.fill(filter, true);

        int m = filter.length;

        filter[1] = false;

        List<Long> primes = new ArrayList<>();

        for (int i = 2; i < m; i++) {
            if (!filter[i]) continue;

            primes.add((long)i);

            for (int j = 2; i * j < m; j++) {
                filter[i * j] = false;
            }
        }

        int count = 0;

        boolean[] notSquare = new boolean[d + 1];

        for (long prime : primes) {
            prime *= prime;

            long q = (min + prime - 1) / prime;

            for (long i = q; i * prime <= max ; i++) {
                notSquare[(int)(i * prime - min)] = true;
            }
        }

        for (int i = 0; i <= d; i++) {
            if (!notSquare[i]) count++;
        }

        System.out.println(count);
    }
}