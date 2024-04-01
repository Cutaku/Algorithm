package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 성곽_2234 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[][] D = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] room = new int[n][m];

        int rNum = 1;

        Queue<int[]> q = new ArrayDeque<>();

        int max = 0;

        int[] rCount = new int[n * m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) {
                    room[i][j] = rNum;

                    int count = 0;

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        count++;

                        for (int k = 0; k < 4; k++) {
                            if ((map[now[0]][now[1]] & (1 << k)) > 0) continue;

                            int x = now[0] + D[k][0];
                            int y = now[1] + D[k][1];

                            if (x < 0 || y < 0 || x >= n || y >= m || room[x][y] > 0) continue;

                            room[x][y] = rNum;

                            q.add(new int[]{x, y});
                        }
                    }

                    max = Math.max(max, count);
                    rCount[rNum++] = count;
                }
            }
        }

        System.out.println(rNum - 1);
        System.out.println(max);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = room[i][j];

                if (i > 0 && room[i - 1][j] != r) {
                    max = Math.max(max, rCount[r] + rCount[room[i - 1][j]]);
                }

                if (j > 0 && room[i][j - 1] != r) {
                    max = Math.max(max, rCount[r] + rCount[room[i][j - 1]]);
                }
            }
        }

        System.out.println(max);
    }
}