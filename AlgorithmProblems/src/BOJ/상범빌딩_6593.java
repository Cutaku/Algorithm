package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩_6593 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] D = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0}, {0, 0, -1}};
        int l, r, c;
        char[][][] building;
        Queue<int[]> q1, q2;
        int ex = 0, ey = 0, ez = 0;
        int t;

        a : while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0) break;

            building = new char[l][r][c];

            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();

                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = line.charAt(k);

                        if (building[i][j][k] == 'S') {
                            q1.add(new int[]{i, j, k});
                            building[i][j][k] = '#';
                        } else if (building[i][j][k] == 'E') {
                            ex = i;
                            ey = j;
                            ez = k;
                        }
                    }
                }

                br.readLine();
            }

            t = 0;

            while (!q1.isEmpty()) {
                int[] now = q1.poll();

                if (now[0] == ex && now[1] == ey && now[2] == ez) {
                    sb.append("Escaped in ").append(t).append(" minute(s).\n");
                    continue a;
                }

                for (int[] d : D) {
                    int x = now[0] + d[0], y = now[1] + d[1], z = now[2] + d[2];

                    if (x < 0 || y < 0 || z < 0 || x >= l || y >= r || z >= c || building[x][y][z] == '#') continue;

                    building[x][y][z] = '#';

                    q2.add(new int[]{x, y, z});
                }

                if (q1.isEmpty()) {
                    Queue<int[]> tmp = q1;
                    q1 = q2;
                    q2 = tmp;

                    t++;                }
            }

            sb.append("Trapped!\n");
        }

        System.out.println(sb);
    }
}