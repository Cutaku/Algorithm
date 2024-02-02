package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 미로탐색_2178 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        char[][] maze= new char[n][];
        for (int i = 0; i < n; i++) maze[i] = br.readLine().toCharArray();

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0});

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 1;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(count);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || maze[x][y] == '0') continue;

                maze[x][y] = '0';

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new ArrayDeque<>();
                count++;
            }
        }
    }
}