package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 함께하는효도 {
    static int n, m;
    static int[][] map;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<int[]>[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new List[m];
        for (int i = 0; i < m; i++) visit[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            int[] v = new int[n];

            v[r] |= 1 << c;

            dfs(0, r, c, v, i);
        }

        List<int[]> v = visit[0];

        for (int i = 1; i < m; i++) {
            List<int[]> temp = new ArrayList<>();

            List<int[]> v2 = visit[i];

            for (int[] a1 : v) {
                for (int[] a2 : v2) {
                    int[] a3 = new int[n];

                    for (int j = 0; j < n; j++) {
                        a3[j] = a1[j] | a2[j];
                    }

                    temp.add(a3);
                }
            }

            v = temp;
        }

        int max = 0;

        for (int[] a : v) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((a[i] & (1 << j)) > 0) sum += map[i][j];
                }
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    static void dfs(int depth, int x, int y, int[] v, int i) {
        if (depth == 3) {
            visit[i].add(v);
            return;
        }

        for (int[] d : D) {
            int[] vc = v.clone();

            int r = x + d[0];
            int c = y + d[1];

            if (r < 0 || c < 0 || r >= n || c >= n) continue;

            vc[r] |= 1 << c;

            dfs(depth + 1, r, c, vc, i);
        }
    }
}