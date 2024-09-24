package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 게임_1584 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] danger = new boolean[501][501];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    danger[j][k] = true;
                }
            }
        }

        boolean[][] death = new boolean[501][501];

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = Math.min(x1, x2); j <= Math.max(x1, x2); j++) {
                for (int k = Math.min(y1, y2); k <= Math.max(y1, y2); k++) {
                    death[j][k] = true;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] v = new boolean[501][501];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        pq.add(new int[]{0, 0, 0});
        v[0][0] = true;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == 500 && poll[1] == 500) {
                System.out.println(poll[2]);
                return;
            }

            for (int[] d : D) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];

                if (x < 0 || y < 0 || x > 500 || y > 500 || death[x][y] || v[x][y]) continue;

                v[x][y] = true;

                pq.add(new int[]{x, y, poll[2] + (danger[x][y] ? 1 : 0)});
            }
        }

        System.out.println(-1);
    }
}