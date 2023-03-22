package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의지름_1167 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());

        List<Edge>[] adj = new List[v + 1];
        for (int i = 1; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int[] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = edges[0];
            int j = 1;
            while (true) {
                int to = edges[j++];
                if (to == -1) break;
                int distance = edges[j++];

                adj[from].add(new Edge(to, distance));
            }
        }

        int[] distances1 = distanceFrom(1, adj);

        int m = 1;
        int max = 0;
        for (int i = 1; i < v + 1; i++) {
            if (distances1[i] > max) {
                max = distances1[i];
                m = i;
            }
        }

        int[] distances2 = distanceFrom(m, adj);
        max = 0;
        for (int i = 1; i < v + 1; i++) {
            if (distances2[i] > max) max = distances2[i];
        }

        System.out.println(max);
    }

    static int[] distanceFrom(int n, List<Edge>[] adj) {

        int[] distances = new int[adj.length + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int from = q.poll();

            for (Edge edge : adj[from]) {
                int to = edge.to;
                int distance = edge.distance;

                if (to != n && distances[to] == 0) {
                    q.add(to);
                    distances[to] = distances[from] + distance;
                }
            }
        }

        return distances;
    }

    static class Edge {
        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}