package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 불_4179 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];

        char[][] maze = new char[r][];
        for (int i = 0; i < r; i++) maze[i] = br.readLine().toCharArray();

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        Queue<int[]> q3 = new LinkedList<>();
        Queue<int[]> q4 = new LinkedList<>();

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maze[i][j] == 'J') {
                    q1.add(new int[]{i, j});
                    visited[i][j] = true;
                } else if (maze[i][j] == 'F') {
                    q3.add(new int[]{i, j});
                }
            }
        }

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 1;

        while (!q1.isEmpty()) {
            while (!q3.isEmpty()) {
                int[] now = q3.poll();

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= r || y >= r || maze[x][y] == '#' || maze[x][y] == 'F') continue;

                    maze[x][y] = 'F';

                    q4.add(new int[]{x, y});
                }
            }

            while (!q1.isEmpty()) {
                int[] now = q1.poll();

                for (int[] d : D) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= r || y >= c) {
                        System.out.println(count);
                        return;
                    }

                    if (visited[x][y] || maze[x][y] == '#' || maze[x][y] == 'F') continue;

                    visited[x][y] = true;

                    q2.add(new int[]{x, y});
                }
            }

            q1 = q2;
            q3 = q4;
            q2 = new LinkedList<>();
            q4 = new LinkedList<>();
            count++;
        }

        System.out.println("IMPOSSIBLE");
    }
}