package BOJ;

import java.io.*;
import java.util.*;

public class 거의최단경로_5719 {
    static int n;
    static int m;
    static List<Integer>[] adj;
    static int[][] roads;
    static Node[] nodes;
    static boolean[] banned;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nm[0];
            m = nm[1];

            if (n == 0 && m == 0) {
                bw.flush();
                return;
            }

            int[] sd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = sd[0], d = sd[1];

            adj = new List[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            roads = new int[m][];
            for (int i = 0; i < m; i++) {
                roads[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adj[roads[i][0]].add(i);
            }

            nodes = new Node[n];
            for (int i = 0; i < n; i++) nodes[i] = new Node();
            nodes[s].min = 0;

            banned = new boolean[m];

            dijkstra(s, d, true);

            for (Node node : nodes) node.fin = false;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(d);

            while (!q.isEmpty()) {
                int i = q.poll();

                for (int r : nodes[i].before) {
                    banned[r] = true;

                    if (nodes[roads[r][0]].fin) continue;

                    nodes[roads[r][0]].fin = true;

                    q.add(roads[r][0]);
                }
            }

            dijkstra(s, d, false);

            if (nodes[d].min == Integer.MAX_VALUE) bw.append("-1\n");
            else bw.append(String.valueOf(nodes[d].min)).append("\n");
        }
    }

    static void dijkstra(int s, int d, boolean b) {

        for(Node node : nodes) {
            node.fin = false;
            node.min = Integer.MAX_VALUE;
        }

        nodes[s].min = 0;

        for (int i = 0; i < n; i++) {
            int ind = findMinInd();

            if (ind == d) return;

            Node node = nodes[ind];
            node.fin = true;

            for (int r : adj[ind]) {
                if (banned[r]) continue;

                int[] road = roads[r];

                Node next = nodes[road[1]];

                if (next.min > node.min + road[2]) {
                    next.min = node.min + road[2];
                    if (b) next.before.clear();
                }

                if (b && next.min == node.min + road[2]) {
                    next.before.add(r);
                }
            }
        }
    }

    static int findMinInd() {

        int min = Integer.MAX_VALUE;
        int minInd = 0;

        for (int i = 0; i < n; i++) {
            if (nodes[i].fin) continue;

            if (min > nodes[i].min) {
                min = nodes[i].min;
                minInd = i;
            }
        }

        return minInd;
    }

    static class Node {
        List<Integer> before = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        boolean fin;
    }
}