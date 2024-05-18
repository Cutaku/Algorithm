package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3_17142 {
    static int n, m;
    static int w, c;
    static int[][] lab;
    static List<int[]> virus;
    static int min;
    static int[] vNum;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][n];

        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 1) {
                    w++;
                } else if (lab[i][j] == 2) {
                    virus.add(new int[]{i, j});
                    c++;
                }
            }
        }

        if (c + w == n * n) {
            System.out.println(0);
            return;
        }

        min = 10000;
        vNum = new int[m];

        dfs(0, 0);

        System.out.println(min == 10000 ? -1 : min);
    }

    static void dfs(int d, int s) {

        if (d == m) {
            min = Math.min(min, bfs(copy()));
            return;
        }

        for (int i = s; i < c; i++) {
            vNum[d] = i;
            dfs(d + 1, i + 1);
        }
    }

    static int bfs(int[][] lab) {

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        int t = 0;
        int count = c;

        boolean[][] used = new boolean[n][n];

        for (int v : vNum) {
            int[] p = virus.get(v);

            q1.add(p);

            used[p[0]][p[1]] = true;
        }

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n || lab[x][y] == 1 || used[x][y]) continue;

                used[x][y] = true;

                if (lab[x][y] == 0) {
                    lab[x][y] = 2;
                    count++;
                }

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                t++;

                if (count + w == n * n) return t;
            }
        }

        return 10000;
    }

    static int[][] copy() {

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            result[i] = lab[i].clone();
        }

        return result;
    }
}