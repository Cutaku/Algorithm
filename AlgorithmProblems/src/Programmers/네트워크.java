package Programmers;

import java.util.*;

class 네트워크 {
    public int solution(int n, int[][] computers) {

        boolean[] used = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (used[i]) continue;

            count++;

            used[i] = true;
            q.add(i);

            while (!q.isEmpty()) {

                int now = q.poll();

                for (int j = 0; j < n; j++) {
                    if (used[j] || computers[now][j] == 0) continue;

                    used[j] = true;
                    q.add(j);
                }
            }
        }

        return count;
    }
}