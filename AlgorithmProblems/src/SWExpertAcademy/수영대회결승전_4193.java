package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 수영대회결승전_4193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] sea = new int[n][];
            for (int i = 0; i < n; i++)  sea[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] min = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(min[i], Integer.MAX_VALUE);

            min[start[0]][start[1]] = 0;

            Queue<int[]> q1 = new LinkedList<>();
            Queue<int[]> q2 = new LinkedList<>();

            q1.add(new int[]{start[0], start[1], 0});

            int count = 0;

            boolean pos = false;

            while (!q1.isEmpty()) {
                int[] now = q1.poll();

                if (now[0] == goal[0] && now[1] == goal[1]) {
                    pos = true;
                    bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(count)).append("\n");
                    break;
                }

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= n || min[x][y] < Integer.MAX_VALUE) continue;
                    if (sea[x][y] == 1 || (sea[x][y] == 2 && count % 3 != 2)) continue;

                    q2.add(new int[]{x, y, 0});
                    min[x][y] = count + 1;
                }

                if (now[2] < 2) q2.add(new int[]{now[0], now[1], now[2] + 1});

                if (q1.isEmpty()) {
                    q1 = q2;
                    q2 = new LinkedList<>();
                    count++;
                }
            }

            if (!pos) bw.append("#").append(String.valueOf(t)).append(" -1\n");
        }

        bw.flush();
    }
}