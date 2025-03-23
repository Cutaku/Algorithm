package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Decision_7873 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][][] dir = {{}, {{1, 0}, {0, -1}}, {{-1, 0}, {0, -1}}, {{-1, 0}, {0, 1}}, {{1, 0}, {0, 1}},
                {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}};

        StringTokenizer st;
        Queue<int[]> q = new ArrayDeque<>();
        int n, m;
        String[] map;
        boolean[][] v;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new String[n];
            for (int i = 0; i < n; i++) map[i] = br.readLine();

            v = new boolean[n][m];

            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (v[i][j]) continue;

                    v[i][j] = true;

                    if (map[i].charAt(j) == 'A') continue;

                    ans++;

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        int[][] D = dir[map[now[0]].charAt(now[1]) - 'A'];

                        for (int[] d : D) {
                            int x = now[0] + d[0], y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= n || y >= m || v[x][y]) continue;

                            int[][] E = dir[map[x].charAt(y) - 'A'];

                            for (int[] e : E) {
                                if (d[0] + e[0] == 0 && d[1] + e[1] == 0) {
                                    q.add(new int[]{x, y});
                                    v[x][y] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}