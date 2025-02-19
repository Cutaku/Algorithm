package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출_16973 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken()), sc = Integer.parseInt(st.nextToken());
        int fr = Integer.parseInt(st.nextToken()), fc = Integer.parseInt(st.nextToken());

        int[][] v = new int[n - h + 2][m - w + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 1) {
                    int r = Math.max(1, i - h + 1), c = Math.max(1, j - w + 1);

                    v[r][c]++;
                    if (i < n - h + 1) v[i + 1][c]--;
                    if (j < m - w + 1) v[r][j + 1]--;
                    if (i < n - h + 1 && j < m - w + 1) v[i + 1][j + 1]++;
                }
            }
        }

        for (int i = 1; i <= n - h + 1; i++) {
            for (int j = 1; j <= m - w + 1; j++) {
                v[i][j] += v[i - 1][j];
            }
        }

        for (int i = 1; i <= n - h + 1; i++) {
            for (int j = 1; j <= m - w + 1; j++) {
                v[i][j] += v[i][j - 1];
            }
        }

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{sr, sc});
        v[sr][sc]++;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cnt = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == fr && now[1] == fc) {
                System.out.println(cnt);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0], y = now[1] + d[1];

                if (x <= 0 || y <= 0 || x > n - h + 1 || y > m - w + 1 || v[x][y] > 0) continue;

                q2.add(new int[]{x, y});
                v[x][y]++;
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