package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_1726 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        boolean[][] factory = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                factory[i][j] = st.nextToken().charAt(0) == '1';
            }
        }

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();
        int[][][] v = new int[m][n][4];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(v[i][j], Integer.MAX_VALUE / 10);
            }
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1, sc = Integer.parseInt(st.nextToken()) - 1;
        int sd = Integer.parseInt(st.nextToken()) - 1;

        if (sd == 1 || sd == 2) {
            sd = 3 - sd;
        }

        st = new StringTokenizer(br.readLine());
        int er = Integer.parseInt(st.nextToken()) - 1, ec = Integer.parseInt(st.nextToken()) - 1;
        int ed = Integer.parseInt(st.nextToken()) - 1;

        if (ed == 1 || ed == 2) {
            ed = 3 - ed;
        }

        q1.add(new int[]{sr, sc, sd});
        v[sr][sc][sd] = 0;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q1.isEmpty()) {
            int[] now = q1.poll();
            int x = now[0], y = now[1], d = now[2];

            for (int i = -1; i < 2; i += 2) {
                int nd = (d + i + 4) % 4;

                if (v[x][y][now[2]] + 1 < v[x][y][nd]) {
                    q2.add(new int[]{x, y, nd});
                    v[x][y][nd] = v[x][y][now[2]] + 1;
                }
            }

            for (int i = 0; i < 3; i++) {
                x += D[d][0];
                y += D[d][1];

                if (x < 0 || y < 0 || x >= m || y >= n || factory[x][y]) break;

                if (v[x][y][d] <= v[now[0]][now[1]][d] + 1) continue;

                v[x][y][d] = v[now[0]][now[1]][d] + 1;
                q2.add(new int[]{x, y, d});
            }

            if (q1.isEmpty()) {
                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
        }

        System.out.println(v[er][ec][ed]);
    }
}