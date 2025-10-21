package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 떡돌리기_20007 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{y, 0});
        dist[y] = 0;

        int cnt = 1;
        int limit = x;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (dist[now[0]] < now[1]) continue;

            int d = 2 * now[1];

            if (d > x) {
                System.out.println(-1);
                return;
            }

            if (d > limit) {
                cnt++;
                limit = x - d;
            } else {
                limit -= d;
            }

            for (int[] next : adj[now[0]]) {
                if (dist[next[0]] <= now[1] + next[1]) continue;

                dist[next[0]] = now[1] + next[1];
                pq.add(new int[]{next[0], now[1] + next[1]});
            }
        }

        System.out.println(cnt);
    }
}