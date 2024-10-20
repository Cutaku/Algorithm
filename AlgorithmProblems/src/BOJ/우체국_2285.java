package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우체국_2285 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), a = Integer.parseInt(st.nextToken());

            sum += a;

            pq.add(new int[]{x, a});
        }

        long m = (sum + 1) / 2;

        int[] poll = null;

        while (m > 0) {
            poll = pq.poll();
            m -= poll[1];
        }

        System.out.println(poll[0]);
    }
}