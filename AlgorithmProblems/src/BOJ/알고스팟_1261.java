package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 알고스팟_1261 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = mn[0];
        int n = mn[1];

        int[][] maze = new int[n][];
        for (int i = 0; i < n; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        boolean[][] check = new boolean[n][];
        for (int i = 0; i < n; i++) {
            boolean[] temp = new boolean[m];
            check[i] = temp;
        }

        q1.add(new int[] {0, 0});

        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (!check[now[0]][now[1]]) {
                check[now[0]][now[1]] = true;

                if (now[0] == n - 1 && now[1] == m - 1) {
                    System.out.println(count);
                    return;
                }

                for (int[] d : D) {
                    int i = now[0] + d[0];
                    int j = now[1] + d[1];
                    int[] temp = {i, j};

                    if (i >= 0 && j >= 0 && i < n && j < m && !check[i][j]) {
                        if (maze[i][j] == 0) {
                            q1.add(temp);
                        } else {
                            q2.add(temp);
                        }
                    }
                }
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }
    }
}