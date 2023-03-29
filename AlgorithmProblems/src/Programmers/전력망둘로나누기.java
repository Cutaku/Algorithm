package Programmers;

import java.util.*;

class 전력망둘로나누기 {
    static int[] count;
    static boolean[] used;
    static List<Integer>[] adj;

    public int solution(int n, int[][] wires) {

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        count = new int[n + 1];
        used = new boolean[n + 1];

        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }

        used[1] = true;
        count[1] = subTree(1);

        int min = n;

        for (int[] wire : wires) {
            int s = Math.min(count[wire[0]], count[wire[1]]);
            int dif = n - 2 * s;
            if (dif < 0) dif *= -1;

            min = Math.min(min, dif);
        }

        return min;
    }

    int subTree(int i) {

        int c = 1;

        for (int j : adj[i]) {
            if (!used[j]) {
                used[j] = true;
                c += subTree(j);
            }
        }

        count[i] = c;

        return c;
    }
}