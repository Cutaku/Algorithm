package Programmers;

import java.util.*;

class 미로탈출 {
    public int solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = maps[i].toCharArray();

        int[][] visited = new int[n][m];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    visited[i][j] = 1;
                    q1.add(new int[]{i, j});
                }
            }
        }

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        int v = 1;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (v == 1 && map[now[0]][now[1]] == 'L') {
                q1.clear();
                q2.clear();

                q1.add(now);
                visited[now[0]][now[1]] = ++v;

                continue;
            }

            if (v == 2 && map[now[0]][now[1]] == 'E') {
                return count;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 'X' || visited[x][y] == v) continue;

                visited[x][y] = v;

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        return -1;
    }
}