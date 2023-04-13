package Programmers;

import java.util.*;

class 아이템줍기 {
    static int n;
    static int[][] rects;

    public int solution(int[][] r, int X, int Y, int x, int y) {

        n = r.length;
        rects = r;

        for (int[] rect : rects) {
            for (int i = 0; i < 4; i++) rect[i] *= 2;
        }

        X *= 2;
        Y *= 2;
        x *= 2;
        y *= 2;

        boolean[][] v = new boolean[101][];
        for (int i = 0; i < 101; i++) v[i] = new boolean[101];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        q1.add(new int[] {X, Y});
        v[X][Y] = true;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        while (!q1.isEmpty()) {

            int[] now = q1.poll();

            if (now[0] == x && now[1] == y) break;

            for (int[] d : D) {
                int i = now[0] + d[0];
                int j = now[1] + d[1];

                if (i < 0 || j < 0 || i > 100 || j > 100 || v[i][j]) continue;

                v[i][j] = true;

                if (pos(i, j)) {
                    q2.add(new int[] {i, j});
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        return count / 2;
    }

    public boolean pos(int x, int y) {

        boolean result = false;

        for (int i = 0; i < n; i++) {
            int[] r = rects[i];

            if (x > r[0] && x < r[2] && y > r[1] && y < r[3]) return false;

            if (
                    ((x == r[0] || x == r[2]) && y >= r[1] && y <= r[3]) ||
                            ((y == r[1] || y == r[3]) && x >= r[0] && x <= r[2])
            ) {
                result = true;
            }
        }

        return result;
    }

    public int solution2(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[][] board = new int[101][];

        for (int i = 0; i < 101; i++) {
            int[] temp = new int[101];
            Arrays.fill(temp, -1);
            board[i] = temp;
        }

        for (int[] rect : rectangle) {
            int x1 = rect[0], x2 = rect[2];
            int y1 = rect[1], y2 = rect[3];

            for (int i = x1; i < x2; i++) {
                if (board[i][y1] == 3) continue;
                board[i][y1] = 0;
            }

            for (int i = y1; i < y2; i++) {
                if (board[x2][i] == 0) continue;
                board[x2][i] = 1;
            }

            for (int i = x2; i > x1; i--) {
                if (board[i][y2] == 1) continue;
                board[i][y2] = 2;
            }

            for (int i = y2; i > y1; i--) {
                if (board[x1][i] == 2) continue;
                board[x1][i] = 3;
            }
        }

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int cnt1 = 0;
        int cnt2 = 0;

        int x = characterX;
        int y = characterY;

        while (x != itemX || y != itemY) {
            int[] d = D[board[x][y]];

            x += d[0];
            y += d[1];

            cnt1++;
        }

        while (x != characterX || y != characterY) {
            int[] d = D[board[x][y]];

            x += d[0];
            y += d[1];

            cnt2++;
        }

        return Math.min(cnt1, cnt2);
    }
}