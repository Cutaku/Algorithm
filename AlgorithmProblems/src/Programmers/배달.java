package Programmers;

import java.util.*;

class 배달 {
    public int solution(int N, int[][] road, int K) {

        int lm = 20000000;

        List<int[]>[] adj = new List[N + 1];
        for (int i = 0; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int[] r : road) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        boolean[] fin = new boolean[N + 1];

        int[] minDistances = new int[N + 1];
        Arrays.fill(minDistances, lm);

        minDistances[1] = 0;

        for (int i = 0; i < N ;i++) {
            int min = lm;
            int minId = 0;

            for (int j = 1; j <= N; j++) {
                if (fin[j]) continue;

                if (min > minDistances[j]){
                    min = minDistances[j];
                    minId = j;
                }
            }

            fin[minId] = true;

            for (int[] r : adj[minId]) {
                if (fin[r[0]]) continue;

                minDistances[r[0]] = Math.min(minDistances[r[0]], minDistances[minId] + r[1]);
            }
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (minDistances[i] <= K) ans++;
        }

        return ans;
    }
}