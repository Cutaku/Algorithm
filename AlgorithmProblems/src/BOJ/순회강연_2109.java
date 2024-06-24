package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 순회강연_2109 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        pq.add(new int[]{0, 1});

        int last = 10001;
        int ans = 0;

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b)-> b - a);

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            pq2.add(poll[0]);

            int r = Math.min(pq2.size(), last - poll[1]);

            for (int i = 0; i < r; i++) {
                ans += pq2.poll();
            }

            last = poll[1];
        }

        System.out.println(ans);
    }
}