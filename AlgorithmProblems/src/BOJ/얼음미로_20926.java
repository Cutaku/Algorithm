package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 얼음미로_20926 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

        char[][] maze = new char[h][w];
        for (int i = 0; i < h; i++) maze[i] = br.readLine().toCharArray();

        int[][] min = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t[2]));

        int ex = 0, ey = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maze[i][j] == 'T') {
                    pq.add(new int[]{i, j, 0});
                    min[i][j] = 0;
                } else if (maze[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == ex && now[1] == ey) {
                System.out.println(now[2]);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                int sum = 0;

                while (x >= 0 && y >= 0 && x < h && y < w && maze[x][y] >= '0' && maze[x][y] <= '9') {
                    sum += maze[x][y] - '0';
                    x += d[0];
                    y += d[1];
                }

                if (x >= 0 && y >= 0 && x < h && y < w) {
                    if (maze[x][y] == 'R') {
                        x -= d[0];
                        y -= d[1];

                        if (min[x][y] > now[2] + sum) {
                            pq.add(new int[]{x, y, now[2] + sum});
                            min[x][y] = now[2] + sum;
                        }
                    } else if (maze[x][y] == 'E') {
                        if (min[x][y] > now[2] + sum) {
                            pq.add(new int[]{x, y, now[2] + sum});
                            min[x][y] = now[2] + sum;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}