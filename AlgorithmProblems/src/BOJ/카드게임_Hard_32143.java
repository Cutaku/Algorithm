package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드게임_Hard_32143 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            int d = Integer.parseInt(st.nextToken());
            sum += d;
            pq.add(d);

            while (!pq.isEmpty() && sum - pq.peek() >= h) sum -= pq.poll();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum >= h ? pq.size() : -1).append("\n");

        while (q-- > 0) {
            int d = Integer.parseInt(br.readLine());

            sum += d;
            pq.add(d);

            while (!pq.isEmpty() && sum - pq.peek() >= h) sum -= pq.poll();

            sb.append(sum >= h ? pq.size() : -1).append("\n");
        }

        System.out.println(sb);
    }
}