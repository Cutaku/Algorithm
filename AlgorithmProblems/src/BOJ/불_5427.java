package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_5427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        a: while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

            Queue<int[]> q1 = new ArrayDeque<>();
            Queue<int[]> q2 = new ArrayDeque<>();

            Queue<int[]> fire1 = new ArrayDeque<>();
            Queue<int[]> fire2 = new ArrayDeque<>();

            boolean[][] map = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String line = br.readLine();

                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);

                    if (c == '*') {
                        fire1.add(new int[] {i, j});
                        map[i][j] = true;
                    } else if (c == '#') {
                        map[i][j] = true;
                    } else if (c == '@') {
                        q1.add(new int[] {i, j});
                        map[i][j] = true;
                    }
                }
            }

            int t = 1;

            int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            while (!q1.isEmpty()) {
                while (!fire1.isEmpty()) {
                    int[] now = fire1.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0], y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= h || y >= w || map[x][y]) continue;

                        map[x][y] = true;

                        fire2.add(new int[] {x, y});
                    }
                }

                while (!q1.isEmpty()) {
                    int[] now = q1.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0], y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= h || y >= w) {
                            sb.append(t).append("\n");
                            continue a;
                        }

                        if (map[x][y]) continue;

                        map[x][y] = true;

                        q2.add(new int[] {x, y});
                    }
                }

                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;

                tmp = fire1;
                fire1 = fire2;
                fire2 = tmp;

                t++;
            }

            sb.append("IMPOSSIBLE\n");
        }

        System.out.println(sb);
    }
}