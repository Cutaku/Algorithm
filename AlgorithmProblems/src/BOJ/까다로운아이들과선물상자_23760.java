package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 까다로운아이들과선물상자_23760 {
    static int n;
    static int[] tree;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[100001];
        max = 100000;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);

            add(c, 1);
        }

        StringTokenizer W = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int w = Integer.parseInt(W.nextToken());
            int b = Integer.parseInt(B.nextToken());

            int p = find(b);

            if (p - w < 0) {
                System.out.println(0);
                return;
            }

            add(p, -1);
            add(p - w, 1);
        }

        System.out.println(1);
    }

    static int find(int i) {

        if (tree[0] > n - i) return 0;

        int s = 0, e = max;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (sum(m) > n - i) e = m;
            else s = m;
        }

        return e;
    }

    static void add(int i, int a) {

        if (i == 0) {
            tree[0] += a;
            return;
        }

        while (i <= max) {
            tree[i] += a;
            i += i & -i;
        }
    }

    static int sum(int i) {

        int res = tree[0];

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}