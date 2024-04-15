package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기3_16933 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        boolean[][][] day = new boolean[n][m][k + 1];
        boolean[][][] night = new boolean[n][m][k + 1];

        Queue<int[]> qDay = new ArrayDeque<>();
        Queue<int[]> qNight = new ArrayDeque<>();

        qDay.add(new int[]{0, 0, 0});
        day[0][0][0] = true;

        int t = 0;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> qNow;
        Queue<int[]> qNext;
        boolean[][][] vNext;

        while (!qDay.isEmpty() || !qNight.isEmpty()) {
            if (t % 2 == 0) {
                qNow = qDay;
                qNext = qNight;
                vNext = night;
            } else {
                qNow = qNight;
                qNext = qDay;
                vNext = day;
            }

            while (!qNow.isEmpty()) {
                int[] now = qNow.poll();
                int r = now[0], c = now[1], hit = now[2];

                if (r == n - 1 && c == m - 1) {
                    System.out.println(t + 1);
                    return;
                }

                if (!vNext[r][c][hit]) {
                    vNext[r][c][hit] = true;
                    qNext.add(new int[]{r, c, hit});
                }

                for (int i = 0; i < 4; i++) {
                    int[] d = D[i];

                    int x = r + d[0];
                    int y = c + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= m) continue;

                    if (!map[x][y] && !vNext[x][y][hit]) {
                        vNext[x][y][hit] = true;
                        qNext.add(new int[]{x, y, hit});
                    }

                    if (map[x][y] && t % 2 == 0 && hit < k && !vNext[x][y][hit + 1]) {
                        vNext[x][y][hit + 1] = true;
                        qNext.add(new int[]{x, y, hit + 1});
                    }
                }
            }

            t++;
        }

        System.out.println(-1);
    }
}