package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 펭귄의하루_29703 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        int[][] v = new int[n][m];

        int tr = 0, tc = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'S') {
                    q1.add(new int[] {i, j, 0});
                    v[i][j] = 1;
                } else if (map[i][j] == 'H') {
                    tr = i;
                    tc = j;
                } else if (map[i][j] == 'D') {
                    v[i][j] = 2;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cnt = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == tr && now[1] == tc && now[2] == 1) {
                System.out.println(cnt);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0], y = now[1] + d[1];

                if (x < 0 || x >= n || y < 0 || y >= m || now[2] < v[x][y]) continue;

                v[x][y] = now[2] + 1;

                q2.add(new int[] {x, y, map[x][y] == 'F' ? 1 : now[2]});
            }

            if (q1.isEmpty()) {
                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;

                cnt++;
            }
        }

        System.out.println(-1);
    }
}