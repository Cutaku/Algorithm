package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가장작은수_26601 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = 2000003;

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        boolean[] isNotPrime = new boolean[15000000];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(2);

        for (int i = 3; i < 15000000; i += 2) {
            if (isNotPrime[i]) continue;

            pq.add(i);

            for (int j = 3; i * j < 15000000; j += 2) {
                isNotPrime[i * j] = true;
            }
        }

        long ans = 1;

        for (int i = 0; i < n; i++) {
            int p = pq.poll();

            ans = ans * p % d;

            if (p < 4000) pq.add(p * p);
        }

        System.out.println(ans);
    }
}