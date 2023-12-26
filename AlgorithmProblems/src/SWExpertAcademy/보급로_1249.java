package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 보급로_1249 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            int[][] min = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(min[i], Integer.MAX_VALUE);

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0, 0, 0});

            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= n || min[x][y] <= now[2] + map[x][y]) continue;

                    q.add(new int[]{x, y, now[2] + map[x][y]});
                    min[x][y] = now[2] + map[x][y];
                }
            }

            bw.append("#").append(String.valueOf(t))
                    .append(" ").append(String.valueOf(min[n - 1][n - 1]))
                    .append("\n");
        }

        bw.flush();
    }
}