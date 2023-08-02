package Programmers;

import java.util.*;

class 등대 {
    List<Integer>[] adj;
    boolean[] isParent;

    public int solution(int n, int[][] lighthouse) {

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] e : lighthouse) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        isParent = new boolean[n + 1];

        int[] root = findMin(1);

        return Math.min(root[0], root[1]);
    }

    public int[] findMin(int n) {

        isParent[n] = true;

        int[] result = new int[2];

        for (int child : adj[n]) {
            if (isParent[child]) continue;

            int[] min = findMin(child);

            result[0] += Math.min(min[0], min[1]);
            result[1] += min[0];
        }

        result[0]++;

        return result;
    }
}