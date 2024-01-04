package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 미로1_1226 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] D = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int tc = 1; tc <= 10; tc++) {
            bw.append("#").append(br.readLine()).append(" ");

            int[][] maze = new int[16][];
            for (int i = 0; i < 16; i++) {
                maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            Queue<int[]> q = new LinkedList<>();

            for (int i = 1; i < 15; i++) {
                for (int j = 1; j < 15; j++) {
                    if (isClosed(maze, i, j) && maze[i][j] == 0) {
                        q.add(new int[]{i, j});
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] now = q.poll();

                maze[now[0]][now[1]] = 1;

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 1 || y < 1 || x > 14 || y > 14 || maze[x][y] > 0) continue;

                    if (isClosed(maze, x, y)) q.add(new int[]{x, y});
                }
            }

            if (maze[0][1] * maze[1][0] * maze[1][2] * maze[2][1] > 0) bw.append("0\n");
            else bw.append("1\n");
        }

        bw.flush();
    }

    public static boolean isClosed(int[][] maze, int i, int j) {

        int c = 0;

        if (maze[i - 1][j] == 1) c++;
        if (maze[i][j - 1] == 1) c++;
        if (maze[i + 1][j] == 1) c++;
        if (maze[i][j + 1] == 1) c++;

        return c == 3;
    }
}