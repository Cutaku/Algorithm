package Programmers;

import java.util.*;

class 무인도여행 {
    public int[] solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;

                visited[i][j] = true;

                if (maps[i].charAt(j) == 'X') continue;

                q.add(new int[]{i, j});

                int count = maps[i].charAt(j) - '0';

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) continue;

                        visited[x][y] = true;

                        if (maps[x].charAt(y) == 'X') continue;

                        count += maps[x].charAt(y) - '0';
                        q.add(new int[]{x, y});
                    }
                }

                pq.add(count);
            }
        }

        int[] ans = new int[pq.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }

        if (ans.length == 0) return new int[]{-1};
        else return ans;
    }
}