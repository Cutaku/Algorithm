package Programmers;

import java.util.*;

class 게임맵최단거리 {
    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q1.add(new int[] {0, 0});
        maps[0][0] = 0;

        int count = 1;
        boolean pos = false;

        while (!q1.isEmpty()) {

            int[] now = q1.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                pos = true;
                break;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || maps[x][y]  == 0) continue;

                maps[x][y] = 0;
                q2.add(new int[] {x, y});
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        if (pos) return count;
        else return -1;
    }
}