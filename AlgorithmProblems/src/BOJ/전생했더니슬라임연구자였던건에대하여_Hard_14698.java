package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전생했더니슬라임연구자였던건에대하여_Hard_14698 {
    static final int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) pq.add(Long.parseLong(st.nextToken()));

            long ans = 1L;

            while (pq.size() > 1) {
                long x = pq.poll() * pq.poll();

                ans = ans * (x % 1000000007) % 1000000007;
                pq.add(x);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}