package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HSAT_6_출퇴근길 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        List<Integer>[] rAdj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            rAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            adj[x].add(y);
            rAdj[y].add(x);
        }

        int[] visited = new int[n];

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()) - 1;
        int e = Integer.parseInt(st.nextToken()) - 1;

        bfs(s, e, adj, visited);
        bfs(e, s, adj, visited);
        bfs(s, s, rAdj, visited);
        bfs(e, e, rAdj, visited);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 4) count++;
        }

        System.out.println(count);
    }

    static void bfs(int s, int e, List<Integer>[] adj, int[] visited) {

        int n = visited.length;

        boolean[] v = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        q.add(s);
        v[s] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if (next == e) continue;

                if (v[next]) continue;
                v[next] = true;

                visited[next]++;

                q.add(next);
            }
        }
    }
}
