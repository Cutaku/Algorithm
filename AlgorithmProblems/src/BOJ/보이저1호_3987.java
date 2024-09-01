package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보이저1호_3987 {
    static int n, m;
    static int[][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][][] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;

        char[] dir = {'U', 'R', 'D', 'L'};

        int max = 0;
        int mIdx = 0;

        for (int i = 0; i < 4; i++) {
            v = new boolean[n][m][4];

            int m = dfs(0, r, c, i);

            if (m > max) {
                max = m;
                mIdx = i;
            }
        }

        System.out.println(dir[mIdx]);
        System.out.println(max == Integer.MAX_VALUE ? "Voyager" : max);
    }

    static int dfs(int t, int x, int y, int d) {

        if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 'C') return t;

        if (map[x][y] == '/') d ^= 1;
        else if (map[x][y] == '\\') d = 3 - d;

        if (v[x][y][d]) return Integer.MAX_VALUE;
        v[x][y][d] = true;

        return dfs(t + 1, x + D[d][0], y + D[d][1], d);
    }
}