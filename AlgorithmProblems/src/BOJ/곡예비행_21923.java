package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 곡예비행_21923 {
    static int n, m;
    static int[][] score, rise, descend;
    static int initial = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        score = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rise = new int[n][m];
        descend = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(rise[i], initial);
            Arrays.fill(descend[i], initial);
        }

        int ans = initial;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, rise(i, j) + descend(i, j));
            }
        }

        System.out.println(ans);
    }

    static int rise(int r, int c) {

        if (rise[r][c] != initial) return rise[r][c];

        int before = initial;

        if (r < n - 1) before = rise(r + 1, c);
        if (c > 0) before = Math.max(before, rise(r, c - 1));

        return rise[r][c] = score[r][c] + (before == initial ? 0 : before);
    }

    static int descend(int r, int c) {

        if (descend[r][c] != initial) return descend[r][c];

        int before = initial;

        if (r < n - 1) before = descend(r + 1, c);
        if (c < m - 1) before = Math.max(before, descend(r, c + 1));

        return descend[r][c] = score[r][c] + (before == initial ? 0 : before);
    }
}