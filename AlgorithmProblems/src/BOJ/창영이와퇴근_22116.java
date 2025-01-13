package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 창영이와퇴근_22116 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] v = new boolean[n][n];

        pq.add(new int[]{0, 0, 0});

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == n - 1 && now[1] == n - 1) {
                System.out.println(now[2]);
                return;
            }

            if (v[now[0]][now[1]]) continue;
            v[now[0]][now[1]] = true;

            for (int[] d : D) {
                int x = now[0] + d[0], y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n || v[x][y]) continue;

                pq.add(new int[]{x, y, Math.max(now[2], Math.abs(map[now[0]][now[1]] - map[x][y]))});
            }
        }
    }
}