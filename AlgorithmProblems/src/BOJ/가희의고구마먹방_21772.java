package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가희의고구마먹방_21772 {
    static int r, c, t;
    static char[][] map;
    static int max;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] wall;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        wall = new boolean[r][c];
        max = 0;

        int[] start = {0, 0};

        for (int i = 0; i < r; i++) {
            String line = br.readLine();

            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'G') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == '#') {
                    wall[i][j] = true;
                }
            }
        }

        dfs(0, start[0], start[1], 0);

        System.out.println(max);
    }

    static void dfs(int depth, int i, int j, int count) {

        if (depth == t) return;

        for (int[] d : D) {
            int x = i + d[0], y = j + d[1];

            if (x < 0 || x >= r || y < 0 || y >= c || wall[x][y]) continue;

            if (map[x][y] == 'S') {
                map[x][y] = '.';
                max = Math.max(max, count + 1);
                dfs(depth + 1, x, y, count + 1);
                map[x][y] = 'S';
            } else {
                dfs(depth + 1, x, y, count);
            }
        }
    }
}