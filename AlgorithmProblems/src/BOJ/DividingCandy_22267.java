package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DividingCandy_22267 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                pq.poll();
                cnt++;
                break;
            } else if (pq.size() == 2 && cnt == 0) {
                cnt = 2;
                break;
            }

            int p = pq.poll();

            if (p == pq.peek()) {
                pq.poll();
                pq.add(p + 1);
            } else {
                cnt++;
            }

            if (cnt > 2) break;
        }

        System.out.println(cnt == 2 ? "Y" : "N");
    }
}