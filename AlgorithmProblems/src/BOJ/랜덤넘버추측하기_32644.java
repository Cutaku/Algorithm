package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜덤넘버추측하기_32644 {
    static int n;
    static int[] p;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        tree = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            add(i, p[i]);
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());

            sb.append(sum(k)).append(" ");
            add(k, -p[k]);
        }

        System.out.println(sb);
    }

    static void add(int i, int a) {

        while (i <= n) {
            tree[i] += a;
            i += i & -i;
        }
    }

    static long sum(int i) {

        long res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}