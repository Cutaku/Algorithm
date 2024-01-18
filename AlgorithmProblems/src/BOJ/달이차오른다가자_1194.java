package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 달이차오른다가자_1194 {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        boolean[][][] visited = new boolean[n][m][64];

        char[][] maze = new char[n][];
        for (int i = 0; i < n; i++) maze[i] = br.readLine().toCharArray();

        Queue<Minsik> q1 = new LinkedList<>();
        Queue<Minsik> q2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == '0') {
                    q1.add(new Minsik(i, j, new boolean['z' + 1]));
                    break;
                }
            }
        }

        int count = 0;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q1.isEmpty()) {
            Minsik now = q1.poll();

            if (maze[now.i][now.j] == '1') {
                System.out.println(count);
                return;
            }

            if (maze[now.i][now.j] >= 'a' && maze[now.i][now.j] <= 'f') {
                now.keys[maze[now.i][now.j]] = true;
            }

            int t = toInt(now.keys);

            for (int[] d : D) {
                int x = now.i + d[0];
                int y = now.j + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y][t] || maze[x][y] == '#') continue;

                boolean[] k = now.keys.clone();

                if (maze[x][y] >= 'A' && maze[x][y] <= 'F') {
                    if (!now.keys[maze[x][y] - ('A' - 'a')]) continue;
                }

                visited[x][y][t] = true;

                q2.add(new Minsik(x, y, k));
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        System.out.println(-1);
    }

    public static class Minsik {
        int i;
        int j;
        boolean[] keys;

        public Minsik(int i, int j, boolean[] keys) {
            this.i = i;
            this.j = j;
            this.keys = keys;
        }
    }

    public static int toInt(boolean[] v) {

        int result = 0;

        for (int i = 0; i < 6; i++) {
            if (v['a' + i]) result += (int) Math.pow(2, i);
        }

        return result;
    }
}