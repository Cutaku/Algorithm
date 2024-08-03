package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치_1395 {
    static int n, m;
    static int[] tree;
    static boolean[] reverse;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n << 2];
        reverse = new boolean[n << 2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '0') {
                modify(1, 0, n - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            } else {
                sb.append(count(1, 0, n - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1))
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    static void modify(int t, int l, int r, int s, int e) {

        reverse(t, l, r);

        if (r < s || e < l) return;

        if (s <= l && r <= e) {
            reverse[t] = !reverse[t];
            reverse(t, l, r);
            return;
        }

        int m = (l + r) >> 1;

        modify(t << 1, l, m, s, e);
        modify(t << 1 | 1, m + 1, r, s, e);

        tree[t] = tree[t << 1] + tree[t << 1 | 1];
    }

    static int count(int t, int l, int r, int s, int e) {

        if (r < s || e < l) return 0;

        reverse(t, l, r);

        if (s <= l && r <= e) return tree[t];

        int m = (l + r) >> 1;

        return count(t << 1, l, m, s, e) + count(t << 1 | 1, m + 1, r, s, e);
    }

    static void reverse(int t, int l, int r) {

        if (reverse[t]) {
            tree[t] = r - l + 1 - tree[t];
            reverse[t] = false;

            if (l < r) {
                reverse[t << 1] = !reverse[t << 1];
                reverse[t << 1 | 1] = !reverse[t << 1 | 1];
            }
        }
    }
}