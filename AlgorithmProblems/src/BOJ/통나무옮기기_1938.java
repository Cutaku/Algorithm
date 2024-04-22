package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class 통나무옮기기_1938 {
    static char[][] map;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        boolean[][] turn = new boolean[n][n];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                turn[i][j] = canTurn(i, j);
            }
        }

        Queue<Pos> q1 = new ArrayDeque<>();
        Queue<Pos> q2 = new ArrayDeque<>();
        Set<Integer> v = new HashSet<>();

        int e = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (map[i][j - 1] == 'B' && map[i][j] == 'B' && map[i][j + 1] == 'B') {
                    Pos p = new Pos(i, j, false);
                    q1.add(p);
                    v.add(p.t);
                }

                if (map[i][j - 1] == 'E' && map[i][j] == 'E' && map[i][j + 1] == 'E') {
                    e = 1000 * i + 10 * j;
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i - 1][j] == 'B' && map[i][j] == 'B' && map[i + 1][j] == 'B') {
                    Pos p = new Pos(i, j, true);
                    q1.add(p);
                    v.add(p.t);
                }

                if (map[i - 1][j] == 'E' && map[i][j] == 'E' && map[i + 1][j] == 'E') {
                    e = 1000 * i + 10 * j + 1;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;

        while (!q1.isEmpty()) {
            Pos now = q1.poll();

            if (now.t == e) {
                System.out.println(count);
                return;
            }

            for (int[] d : D) {
                int r = now.r + d[0];
                int c = now.c + d[1];

                if (now.isVert) {
                    if (!inRange(r, c) || !inRange(r - 1, c) || !inRange(r + 1, c)) continue;
                } else {
                    if (!inRange(r, c) || !inRange(r, c - 1) || !inRange(r, c + 1)) continue;
                }

                Pos next = new Pos(r, c, now.isVert);

                if (v.add(next.t)) {
                    q2.add(next);
                }
            }

            if (turn[now.r][now.c]) {
                Pos next = new Pos(now.r, now.c, !now.isVert);

                if (v.add(next.t)) {
                    q2.add(next);
                }
            }

            if (q1.isEmpty()) {
                Queue<Pos> temp = q1;
                q1 = q2;
                q2 = temp;

                count++;
            }
        }

        System.out.println(0);
    }

    static boolean inRange(int i, int j) {

        return i >= 0 && j >= 0 && i < n && j < n && map[i][j] != '1';
    }

    static boolean canTurn(int r, int c) {

        for (int i = r - 1; i < r + 2; i++) {
            for (int j = c - 1; j < c + 2; j++) {
                if (map[i][j] == '1') return false;
            }
        }

        return true;
    }

    static class Pos {
        int r;
        int c;
        boolean isVert;
        int t;

        public Pos(int r, int c, boolean isVert) {
            this.r = r;
            this.c = c;
            this.isVert = isVert;
            this.t = 1000 * r + 10 * c + (isVert ? 1 : 0);
        }
    }
}
