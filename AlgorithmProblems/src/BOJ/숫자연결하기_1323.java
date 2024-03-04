package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자연결하기_1323 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long m = 10;
        while (m <= n) m *= 10;
        int d = (int) (m % k);

        Set<Integer> set = new HashSet<>();

        n %= k;

        long r = n;

        int count = 1;

        while (set.add((int) r)) {
            if (r == 0) {
                System.out.println(count);
                return;
            }

            count++;
            r = (r * d + n) % k;
        }

        System.out.println(-1);
    }
}