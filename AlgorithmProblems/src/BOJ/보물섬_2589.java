package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {
    static int n, m;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) == 'W';
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) max = Math.max(max, bfs(i, j, copy(map)));
            }
        }

        System.out.println(max);
    }

    static int bfs(int i, int j, boolean[][] map) {

        int t = 0;

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{i, j});
        map[i][j] = true;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || map[x][y]) continue;

                map[x][y] = true;

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                if (!q2.isEmpty()) t++;

                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
        }

        return t;
    }

    static boolean[][] copy(boolean[][] map) {

        boolean[][] result = new boolean[n][];

        for (int i = 0; i < n; i++) {
            result[i] = map[i].clone();
        }

        return result;
    }
}