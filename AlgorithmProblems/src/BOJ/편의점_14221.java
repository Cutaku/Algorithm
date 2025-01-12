package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 편의점_14221 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] d = new int[n];
        boolean[] v = new boolean[n];
        Arrays.fill(d, Integer.MAX_VALUE / 2);

        boolean[] goal = new boolean[n];

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) goal[Integer.parseInt(st.nextToken()) - 1] = true;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) pq.add(new int[]{Integer.parseInt(st.nextToken()) - 1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (goal[now[0]]) {
                System.out.println(now[0] + 1);
                return;
            }

            if (v[now[0]]) continue;

            v[now[0]] = true;

            for (int[] next : adj[now[0]]) {
                if (v[next[0]] || now[1] + next[1] >= d[next[0]]) continue;
                d[next[0]] = now[1] + next[1];
                pq.add(new int[]{next[0], now[1] + next[1]});
            }
        }
    }
}