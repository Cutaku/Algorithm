package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 무빙워크_31723 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Dist>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            long d = Long.parseLong(st.nextToken());

            adj[u].add(new Dist(v, i, d, true));
            adj[u].add(new Dist(v, i, 2 * d, false));
            adj[v].add(new Dist(u, i, 2 * d, false));
        }

        boolean[] on = new boolean[m];

        long[] min = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);

        PriorityQueue<Dist> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));

        pq.add(new Dist(0, 0, 0, true));
        min[0] = 0;

        int cnt = n;
        long ans = 0;

        while (cnt > 0) {
            Dist now = pq.poll();

            if (min[now.idx] < now.dist) continue;

            ans += now.dist;
            cnt--;
            on[now.eIdx] = now.on;

            for (Dist next : adj[now.idx]) {
                if (now.dist + next.dist < min[next.idx]) {
                    min[next.idx] = now.dist + next.dist;
                    pq.add(new Dist(next.idx, next.eIdx, now.dist + next.dist, next.on));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(ans).append("\n");
        for (int i = 0; i < m; i++) sb.append(on[i] ? 1 : 0).append(" ");

        System.out.println(sb);
    }

    static class Dist {
        int idx;
        int eIdx;
        long dist;
        boolean on;

        public Dist(int idx, int eIdx, long dist, boolean on) {
            this.idx = idx;
            this.eIdx = eIdx;
            this.dist = dist;
            this.on = on;
        }
    }
}