package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 제271회웰노운컵_16225 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(new int[]{Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())});
        }

        PriorityQueue<Integer> apq = new PriorityQueue<>(Comparator.reverseOrder());

        long sum = pq.poll()[0];

        for (int i = 0; i < n / 2 - 1; i++) {
            apq.add(pq.poll()[0]);
            apq.add(pq.poll()[0]);
            sum += apq.poll();
        }

        System.out.println(sum);
    }
}