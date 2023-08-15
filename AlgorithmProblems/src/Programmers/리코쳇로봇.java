package Programmers;

import java.util.*;

class 리코쳇로봇 {
    public int solution(String[] board) {

        int n = board.length;
        int m = board[0].length();

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        boolean[][] v = new boolean[n + 2][m + 2];

        char[][] b = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
                    b[i][j] = 'D';
                } else {
                    b[i][j] = board[i - 1].charAt(j - 1);

                    if (b[i][j] == 'R') {
                        q1.add(new int[]{i, j});
                        v[i][j] = true;
                    }
                }
            }
        }

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (b[now[0]][now[1]] == 'G') return count;

            for (int[] d : D) {
                int x = now[0];
                int y = now[1];

                while (b[x + d[0]][y + d[1]] != 'D') {
                    x += d[0];
                    y += d[1];
                }

                if (v[x][y]) continue;

                v[x][y] = true;
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