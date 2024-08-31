package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실_1347 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[2] - a[2];
            return a[1] - b[1];
        });

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<Integer> last = new PriorityQueue<>();

        last.add(pq.poll()[2]);

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (last.peek() <= poll[1])  last.poll();

            last.add(poll[2]);
        }

        System.out.println(last.size());
    }
}