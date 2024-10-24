package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 농장관리_1245 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] mountain = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] D = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        boolean[][] v = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j]) continue;

                boolean isTop = true;

                Queue<int[]> q = new ArrayDeque<>();

                q.add(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    int h = mountain[now[0]][now[1]];

                    for (int[] d : D) {
                        int x = now[0] + d[0], y = now[1] + d[1];

                        if (x < 0 || x >= n || y < 0 || y >= m) continue;

                        if (mountain[x][y] > h) {
                            isTop = false;
                            continue;
                        } else if (mountain[x][y] < h || v[x][y]) {
                            continue;
                        }

                        v[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }

                if (isTop) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}