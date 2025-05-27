package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모래성_10711 {
    static int n, m;
    static int[][] map;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static Queue<int[]> q1, q2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '.') q1.add(new int[] {i, j});
                else map[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = -1;

        while (!q1.isEmpty()) {
            cnt++;

            while (!q1.isEmpty()) {
                int[] p = q1.poll();

                remove(p[0], p[1]);
            }

            Queue<int[]> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        System.out.println(cnt);
    }

    static void remove(int r, int c) {

        for (int i = 0; i < 8; i++) {
            int x = r + D[i][0], y = c + D[i][1];

            if (x < 0 || y < 0 || x >= n || y >= m) continue;

            if (map[x][y] > 0) {
                map[x][y]--;

                if (map[x][y] == 0) q2.add(new int[] {x, y});
            }
        }
    }
}