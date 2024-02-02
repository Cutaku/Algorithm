package BOJ;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 유기농배추_1012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] mnk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = mnk[0], n = mnk[1], k = mnk[2];

            boolean[][] cabbages = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cabbages[p[0]][p[1]] = true;
            }

            Queue<int[]> q = new ArrayDeque<>();

            int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!cabbages[i][j]) continue;

                    count++;

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= m || y >= n || !cabbages[x][y]) continue;

                            cabbages[x][y] = false;

                            q.add(new int[]{x, y});
                        }
                    }
                }
            }

            bw.append(String.format("%d\n", count));
        }

        bw.flush();
    }
}