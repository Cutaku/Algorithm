package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 세부_13905 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adj[v1].add(new int[] {v2, w});
            adj[v2].add(new int[] {v1, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));
        int[] d = new int[n];
        boolean[] v = new boolean[n];

        pq.add(new int[]{s, 1000000});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (v[now[0]]) continue;

            v[now[0]] = true;
            d[now[0]] = now[1];

            if (now[0] == e) break;

            for (int[] next : adj[now[0]]) {
                if (!v[next[0]] && Math.min(now[1], next[1]) > d[next[0]]) {
                    pq.add(new int[]{next[0], Math.min(now[1], next[1])});
                }
            }
        }

        System.out.println(d[e]);
    }
}