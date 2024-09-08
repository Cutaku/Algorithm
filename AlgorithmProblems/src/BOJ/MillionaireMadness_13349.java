package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MillionaireMadness_13349 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ladders = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ladders[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        q.add(new int[]{0, 0, 0});
        ladders[0][0] = 0;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(now[2]);
                return;
            }

            if (now[2] > ladders[now[0]][now[1]]) continue;

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m) continue;

                int ladder = Math.max(ladders[now[0]][now[1]], map[x][y] - map[now[0]][now[1]]);

                if (ladder >= ladders[x][y]) continue;

                q.add(new int[]{x, y, ladder});
                ladders[x][y] = ladder;
            }
        }
    }
}