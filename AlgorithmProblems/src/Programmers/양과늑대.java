package Programmers;

import java.util.*;

class 양과늑대 {
    public int solution(int[] info, int[][] edges) {

        int n = info.length;
        Set<Long> visited = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();

        int[] root = new int[n];
        root[0] = 1;
        q.add(root);
        visited.add(toLong(root));

        int max = 0;

        while (!q.isEmpty()) {

            int[] now = q.poll();

            max = Math.max(max, sum(info, now));

            for (int[] edge : edges) {
                if (now[edge[0]] == 1 && now[edge[1]] == 0) {
                    int[] next = new int[n];
                    for (int i = 0; i < n; i++) next[i] = now[i];
                    next[edge[1]] = 1;

                    if (visited.add(toLong(next)) && check(info, next)) {
                        q.add(next);
                    }
                }
            }
        }

        return max;
    }

    boolean check(int[] info, int[] status) {

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < info.length; i++) {
            if (status[i] == 1) {
                if (info[i] == 0) sheep++;
                else wolf++;
            }
        }

        return (sheep > wolf);
    }

    long toLong(int[] arr) {

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) result += Math.pow(2, i);
        }

        return result;
    }

    int sum(int[] info, int[] arr) {

        int sum = 0;

        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0) sum += arr[i];
        }

        return sum;
    }
}