import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단절선_11400 {
    static int v;
    static int e;
    static List<int[]>[] adj;
    static int[][] edges;
    static boolean[] visited;
    static boolean[] used;
    static int[] order;
    static List<int[]> ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = ve[0];
        e = ve[1];

        adj = new List[v + 1];
        for (int i = 0; i <= v; i++) adj[i] = new ArrayList<>();

        edges = new int[e][];
        for (int i = 0; i < e; i++) {
            edges[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            adj[edges[i][0]].add(new int[]{edges[i][1], i});
            adj[edges[i][1]].add(new int[]{edges[i][0], i});
        }

        visited = new boolean[v + 1];
        used = new boolean[e];
        order = new int[v + 1];
        ans = new ArrayList<>();

        findCycle(1, 0);

        ans.sort((a1, a2) -> {
            if (a1[0] == a2[0]) return a1[1] - a2[1];
            else return a1[0] - a2[0];
        });

        sb.append(ans.size()).append("\n");

        for (int[] a : ans) {
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }

        System.out.print(sb);
    }

    static int findCycle(int v, int d) {

        if (visited[v]) {
            return order[v];
        }

        visited[v] = true;

        order[v] = d;

        int min = d;

        for (int[] edge : adj[v]) {
            if (used[edge[1]]) continue;

            used[edge[1]] = true;

            int res = findCycle(edge[0], d + 1);

            if (d < res) {
                ans.add(edges[edge[1]]);
            }

            min = Math.min(min, res);
        }

        return min;
    }
}