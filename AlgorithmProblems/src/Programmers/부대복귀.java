package Programmers;

import java.util.*;

class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(destination);

        int[] min = new int[n + 1];
        Arrays.fill(min, -1);
        min[destination] = 0;

        while (!q.isEmpty()) {

            int now = q.poll();

            for (int next : adj[now]) {
                if (min[next] >= 0) continue;

                q.add(next);

                min[next] = min[now] + 1;
            }
        }

        for (int i = 0; i < sources.length; i++) {
            sources[i] = min[sources[i]];
        }

        return sources;
    }
}