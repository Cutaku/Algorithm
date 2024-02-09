package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 벽부수고이동하기2_14442 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] v = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(v[i], k + 1);

        q1.add(new int[]{0, 0, 0});
        v[0][0] = 0;

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

                if (x < 0 || y < 0 || x >= n || y >= m || now[2] + map[x][y] >= v[x][y]) continue;

                v[x][y] = now[2] + map[x][y];

                q2.add(new int[]{x, y, v[x][y]});
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                count++;
            }
        }

        System.out.println(-1);
    }
}