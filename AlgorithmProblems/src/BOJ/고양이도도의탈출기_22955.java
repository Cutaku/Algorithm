package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 고양이도도의탈출기_22955 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int er = 0, ec = 0, sr = 0, sc = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'C') {
                    sr = i;
                    sc = j;
                    map[i][j] = 'F';
                } else if (map[i][j] == 'E') {
                    er = i;
                    ec = j;
                }
            }
        }

        int[][] v = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(v[i], Integer.MAX_VALUE >> 1);
        }

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{sr, sc});
        v[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];


            if (map[r][c] == 'X') {
                int x = r + 1;

                if (x == n) continue;

                if (map[x][c] == 'X' && v[x][c] > v[r][c]) {
                    v[x][c] = v[r][c];
                    q.add(new int[]{x, c});
                } else if (map[x][c] != 'D' && v[x][c] > v[r][c] + 10) {
                    v[x][c] = v[r][c] + 10;
                    q.add(new int[]{x, c});
                }
            } else {
                for (int i = -1; i < 2; i += 2) {
                    int y = c + i;

                    if (y < 0 || y == m || map[r][y] == 'D' || v[r][y] <= v[r][c] + 1) continue;

                    v[r][y] = v[r][c] + 1;
                    q.add(new int[]{r, y});
                }

                if (map[r][c] == 'L') {
                    int x = r - 1;

                    if (!(r == 0 || v[x][c] <= v[r][c] + 5 || map[x][c] == 'D')) {
                        v[x][c] = v[r][c] + 5;
                        q.add(new int[]{x, c});
                    }
                }

                if (r < n - 1 && map[r + 1][c] == 'L') {
                    int x = r + 1;

                    if (r == n - 1 || v[x][c] <= v[r][c] + 5) continue;

                    v[x][c] = v[r][c] + 5;
                    q.add(new int[]{x, c});
                }
            }
        }

        if (v[er][ec] == Integer.MAX_VALUE >> 1) System.out.println("dodo sad");
        else System.out.println(v[er][ec]);
    }
}