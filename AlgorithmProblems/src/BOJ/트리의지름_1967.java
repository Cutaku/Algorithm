package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의지름_1967 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] far = findFarthest(1, adj);

        System.out.println(findFarthest(far[0], adj)[1]);
    }

    public static int[] findFarthest(int start, List<int[]>[] adj) {

        int n = adj.length - 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int[] edge : adj[now]) {
                if (distances[edge[0]] >= 0) continue;

                q.add(edge[0]);
                distances[edge[0]] = distances[now] + edge[1];
            }
        }

        int ind = 0;
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (max < distances[i]) {
                max = distances[i];
                ind = i;
            }
        }

        return new int[]{ind, max};
    }
}