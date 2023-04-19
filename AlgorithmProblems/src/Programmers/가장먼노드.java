package Programmers;

import java.util.*;

class 가장먼노드 {
    public int solution(int n, int[][] edges) {

        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(1);
        visited[1] = true;

        int ans = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int next : adj[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                q2.add(next);
            }

            if (q1.isEmpty()) {
                if (!q2.isEmpty()) ans = q2.size();
                q1 = q2;
                q2 = new LinkedList<>();
            }
        }

        return ans;
    }
}