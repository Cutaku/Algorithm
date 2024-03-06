package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 간선이어가기2_14284 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] adj  = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adj[v1].add(new int[]{v2, w});
            adj[v2].add(new int[]{v1, w});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()) - 1;
        int t = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

        int[] d = new int[n];
        Arrays.fill(d, 500000);

        pq.add(new int[]{s, 0});
        d[s] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == t) {
                System.out.println(now[1]);
                return;
            }

            if (d[now[0]] < now[1]) continue;

            for (int[] e : adj[now[0]]) {
                if (d[e[0]] > now[1] + e[1]) {
                    d[e[0]] = now[1] + e[1];
                    pq.add(new int[]{e[0], now[1] + e[1]});
                }
            }
        }
    }
}