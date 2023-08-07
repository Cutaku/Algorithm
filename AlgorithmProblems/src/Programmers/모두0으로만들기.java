package Programmers;

import java.util.*;

class 모두0으로만들기 {
    static int n;
    static long count;
    static int[] w;
    static List<Integer>[] adj;
    static boolean[] checked;

    public long solution(int[] a, int[][] edges) {

        long sum = 0;

        for (int num : a) sum += num;

        if (sum != 0) return -1;

        n = a.length;
        count = 0;

        w = a;

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        checked = new boolean[n];

        toRoot(0);

        return count;
    }

    public long toRoot(int m) {

        checked[m] = true;

        long sum = 0;

        for (int i = 0; i < adj[m].size(); i++) {
            int child = adj[m].get(i);

            if (checked[child]) continue;

            long r = toRoot(child);

            sum += r;

            if (r > 0) count += r;
            else count -= r;
        }

        return sum + w[m];
    }
}