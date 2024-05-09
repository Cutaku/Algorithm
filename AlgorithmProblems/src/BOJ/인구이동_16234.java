package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_16234 {
    static int n, l, r;
    static int[][] nations;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        nations = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;

        while (move()) t++;

        System.out.println(t);
    }

    static boolean move() {

        boolean res = false;

        boolean[][] v = new boolean[n][n];

        List<int[]> list;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j]) continue;

                list = new ArrayList<>();
                list.add(new int[]{i, j});
                v[i][j] = true;

                int idx = 0;
                int size = nations[i][j];

                while (idx < list.size()) {
                    int[] now = list.get(idx++);

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= n || v[x][y] ||
                                Math.abs(nations[now[0]][now[1]] - nations[x][y]) < l ||
                                Math.abs(nations[now[0]][now[1]] - nations[x][y]) > r
                        ) continue;

                        list.add(new int[]{x, y});
                        res = true;

                        v[x][y] = true;
                        size += nations[x][y];
                    }
                }

                int pop = size / list.size();

                for (int[] nation : list) {
                    nations[nation[0]][nation[1]] = pop;
                }
            }
        }

        return res;
    }
}