package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유닛이동시키기_2194 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[n - a + 1][m - b + 1];

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int i = Math.min(x, n - a); i > Math.max(-1, x - a) ; i--) {
                for (int j = Math.min(y, m - b); j > Math.max(-1, y - b); j--) {
                    v[i][j] = true;
                }
            }
        }

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;

        q1.add(new int[]{x, y});
        v[x][y] = true;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;

        int cnt = 0;
        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == x && now[1] == y) {
                System.out.println(cnt);
                return;
            }

            for (int[] d : D) {
                int r = now[0] + d[0], c = now[1] + d[1];

                if (r < 0 || c < 0 || r > n - a || c > m - b || v[r][c]) continue;

                v[r][c] = true;

                q2.add(new int[]{r, c});
            }

            if (q1.isEmpty()) {
                cnt++;

                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }
        }

        System.out.println(-1);
    }
}