package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작_15684 {
    static int n, m, h;
    static int max;
    static boolean[][] hori;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()) - 1;
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        max = n * h;

        hori = new boolean[h][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            hori[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        ans = 4;

        dfs(0, 0);

        System.out.println(ans == 4 ? -1 : ans);
    }

    static void dfs(int d, int idx) {

        if (check()) {
            ans = Math.min(ans, d);
            return;
        }

        if (d == 3) return;

        for (int i = idx; i < max; i++) {
            int r = i / n;
            int c = i % n;

            if (hori[r][c]) continue;

            if (c > 0 && hori[r][c - 1]) continue;
            if (c < n - 1 && hori[r][c + 1]) continue;

            hori[r][c] = true;
            dfs(d + 1, i + 1);
            hori[r][c] = false;
        }
    }

    static boolean check() {

        int[] lane = new int[n + 1];
        for (int i = 1; i <= n; i++) lane[i] = i;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                if (hori[i][j]) {
                    int tmp = lane[j];
                    lane[j] = lane[j + 1];
                    lane[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (lane[i] != i) return false;
        }

        return true;
    }
}