package BOJ;

import java.io.*;
import java.util.*;

public class 안전영역_2468 {
    static int n;
    static int[][] heights;
    static int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        heights = new int[n][];
        for (int i = 0; i < n; i++) {
            heights[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int safe = 1;
        int h = 0;
        int max = 1;

        while (safe > 0) {
            safe = findSafeArea(++h);
            max = Math.max(max, safe);
        }

        System.out.println(max);
    }

    static int findSafeArea(int h) {

        boolean[][] checked = new boolean[n][n];

        int count = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isSafe(h, i, j) && !checked[i][j]) {
                    count++;

                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= n || y >= n || !isSafe(h, x, y) || checked[x][y]) continue;

                            checked[x][y] = true;

                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return count;
    }

    static boolean isSafe(int h, int i, int j) {
        return heights[i][j] > h;
    }
}