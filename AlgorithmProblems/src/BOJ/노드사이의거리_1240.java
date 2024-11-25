package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의거리_1240 {
    static int n, m;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()) - 1, u = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            adj[v].add(new int[]{u, d});
            adj[u].add(new int[]{v, d});
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            sb.append(bfs(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int s, int e) {

        boolean[] v = new boolean[n];

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{s, 0});
        v[s] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == e) return now[1];

            for (int[] next : adj[now[0]]) {
                if (v[next[0]]) continue;

                v[next[0]] = true;

                q.add(new int[]{next[0], now[1] + next[1]});
            }
        }

        return 0;
    }
}