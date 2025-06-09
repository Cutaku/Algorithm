package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어격자_2418 {
    static int h, w, l;
    static char[][] grid;
    static long[][][] save;
    static String word;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        grid = new char[h][w];
        save = new long[h][w][l];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();

            for (int j = 0; j < w; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        word = br.readLine();
        long res = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                res += count(i, j, 0);
            }
        }

        System.out.println(res);
    }

    static long count(int r, int c, int idx) {

        if (grid[r][c] != word.charAt(idx)) return 0;
        if (save[r][c][idx] > 0) return save[r][c][idx] - 1;

        if (idx == l - 1) {
            save[r][c][idx] = 2;
            return 1;
        }

        long res = 0;

        for (int[] d : D) {
            int x = r + d[0], y = c + d[1];

            if (x < 0 || y < 0 || x >= h || y >= w) continue;

            res += count(x, y, idx + 1);
        }

        save[r][c][idx] = res + 1;
        return res;
    }
}