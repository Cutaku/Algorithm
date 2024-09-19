package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 미로만들기_2665 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] maze = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j) == '1';
            }
        }

        int[][] v = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(v[i], 2500);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        pq.add(new int[]{0, 0, 0});
        v[0][0] = 0;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == n - 1 && poll[1] == n - 1) {
                System.out.println(poll[2]);
                return;
            }

            for (int[] d : D) {
                int x = poll[0] + d[0], y = poll[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n) continue;

                int z = poll[2] + (maze[x][y] ? 0 : 1);

                if (z < v[x][y]) {
                    pq.add(new int[]{x, y, z});
                    v[x][y] = z;
                }
            }
        }
    }
}