package BOJ;

import java.io.*;
import java.util.*;

public class 구간합구하기2_10999 {
    static long[] segTree;
    static long[] modify;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int l = 1;
        while (n >= l) l <<= 1;
        l <<= 1;

        segTree = new long[l];
        modify = new long[l >> 1];


        for (int i = 1; i <= n; i++) {
            modify(1, 1, n, i, i, Long.parseLong(br.readLine()));
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                modify(1, 1, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            } else {
                sb.append(sum(1, 1, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void modify(int t, int l, int r, int i, int j, long num) {

        if (j < l || r < i) return;

        segTree[t] += intersect(l, r, i, j) * num;

        if (i <= l && r <= j) {
            if (l < r) modify[t] += num;
            return ;
        }

        int m = (l + r) / 2;

        modify(2 * t, l, m, i, j, num);
        modify(2 * t + 1, m + 1, r, i, j, num);
    }

    static long sum(int t, int l, int r, int i, int j) {

        if (j < l || r < i) return 0;
        if (i <= l && r <= j) return segTree[t];

        int m = (l + r) / 2;

        if (modify[t] != 0) {
            segTree[2 * t] += (m - l + 1) * modify[t];
            if (l < m) modify[2 * t] += modify[t];

            segTree[2 * t + 1] += (r - m) * modify[t];
            if (m + 1 < r) modify[2 * t + 1] += modify[t];

            modify[t] = 0;
        }

        return sum(2 * t, l, m, i, j) + sum(2 * t + 1, m + 1, r, i, j);
    }

    static int intersect(int l, int r, int i, int j) {

        return Math.min(r, j) - Math.max(l, i) + 1;
    }
}