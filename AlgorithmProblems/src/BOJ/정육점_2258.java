package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 정육점_2258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int min = Integer.MAX_VALUE;

        int w = 0, c = 0;
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > w) {
                w = cur[1];
                c = 1;
            } else {
                c++;
            }

            sum += cur[0];

            if (sum >= m) {
                min = Math.min(min, w * c);
            }
        }

        System.out.println(sum >= m ? min : -1);
    }
}