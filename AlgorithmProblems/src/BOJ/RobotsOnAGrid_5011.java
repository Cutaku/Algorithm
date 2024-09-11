package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RobotsOnAGrid_5011 {
    static int n;
    static int[][] count;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];
        count = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(count[i], -1);

            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '.';
            }
        }

        count[0][0] = 1;

        int ans = count(n - 1, n - 1);

        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println(bfs() ? "THE GAME IS A LIE" : "INCONCEIVABLE");
        }
    }

    static int count(int i, int j) {

        if (count[i][j] >= 0) return count[i][j];

        long res = 0;

        if (i > 0 && map[i - 1][j]) res += count(i - 1, j);
        if (j > 0 && map[i][j - 1]) res += count(i, j - 1);

        return count[i][j] = (int) (res % Integer.MAX_VALUE);
    }

    static boolean bfs() {

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        map[0][0] = false;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == n - 1) return true;

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n || !map[x][y]) continue;

                map[x][y] = false;

                q.add(new int[]{x, y});
            }
        }

        return false;
    }
}