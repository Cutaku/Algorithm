package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS_1260 {
    static StringBuilder sb;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[] nmv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmv[0], m = nmv[1], v = nmv[2];

        adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        visited = new boolean[n + 1];
        dfs(v);

        sb.append("\n");

        Arrays.fill(visited, false);
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int v) {
        sb.append(String.format("%d ", v));
        visited[v] = true;
        adj[v].stream().distinct().sorted().filter(m -> !visited[m]).forEach(DFS와BFS_1260::dfs);
    }

    static void bfs(int v) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int n = q.poll();

            sb.append(String.format("%d ", n));

            adj[n].stream().distinct().sorted().filter(m -> !visited[m]).forEach(m -> {
                visited[m] = true;
                q.add(m);
            });
        }
    }
}