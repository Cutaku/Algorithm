package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열과쿼리21_16975 {
    static long[] segTree;
    static long[] modify;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int l = 1;

        while ((n << 1) > l) l <<= 1;

        segTree = new long[l];
        modify = new long[l >> 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            modify(1, 1, n, i, i, Long.parseLong(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                modify(1, 1, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            } else {
                sb.append(peek(1, 1, n, Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void modify(int t, int l, int r, int i, int j, long k) {

        if (r < i || j < l) return;

        segTree[t] += k * intersect(l, r, i, j);

        if (i <= l && r <= j) {
            if (l < r) modify[t] += k;
            return;
        }

        int m = (l + r) / 2;

        modify(2 * t, l, m, i, j, k);
        modify(2 * t + 1, m + 1, r, i, j, k);
    }

    static long peek(int t, int l, int r, int x) {

        if (x < l || x > r) return 0;

        if (l == r) return segTree[t];

        int m = (l + r) / 2;

        if (modify[t] != 0) {
            segTree[2 * t] += (m - l + 1) * modify[t];
            segTree[2 * t + 1] += (r - m) * modify[t];

            if (l < m) modify[2 * t] += modify[t];
            if (m + 1 < r) modify[2 * t + 1] += modify[t];

            modify[t] = 0;
        }

        return peek(2 * t, l, m, x) + peek(2 * t + 1, m + 1, r, x);
    }

    static int intersect(int l, int r, int i, int j) {

        return Math.min(r, j) - Math.max(l, i) + 1;
    }
}