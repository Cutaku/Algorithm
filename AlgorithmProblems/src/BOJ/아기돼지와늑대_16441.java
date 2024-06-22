package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기돼지와늑대_16441 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][];

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'W') {
                    q.add(new int[]{i, j});
                    v[i][j] = true;
                } else if (map[i][j] == '#') {
                    v[i][j] = true;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : D) {
                int x = now[0], y = now[1];

                do {
                    x += d[0];
                    y += d[1];
                } while (map[x][y] == '+' && map[x + d[0]][y + d[1]] != '#');

                if (v[x][y]) continue;

                v[x][y] = true;

                q.add(new int[]{x, y});
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (map[i][j] == '.' && !v[i][j]) map[i][j] = 'P';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}