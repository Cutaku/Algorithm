package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라_17836 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][]  castle = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visited = new int[n][m];

        int count = 0;

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0, 0});
        visited[0][0] = 1;

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(count);
                return;
            }

            if (count == t) continue;

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];
                boolean hasSword = now[2] == 1;

                if (x < 0 || y < 0 || x >= n || y >= m) continue;

                if (hasSword && visited[x][y] < 2) {
                    visited[x][y] = 2;
                    q2.add(new int[]{x, y, 1});
                } else if (!hasSword && castle[x][y] != 1 && visited[x][y] < 1) {
                    visited[x][y] = 1;
                    q2.add(new int[]{x, y, castle[x][y] == 2 ? 1 : 0});
                }
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                count++;
            }
        }

        System.out.println("Fail");
    }
}