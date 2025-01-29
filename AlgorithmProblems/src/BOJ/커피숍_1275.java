package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 커피숍_1275 {
    static int n, q;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) update(i, Long.parseLong(st.nextToken()));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            sb.append(sum(Math.max(x, y)) - sum(Math.min(x, y) - 1)).append("\n");
            update(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        System.out.println(sb);
    }

    static void update(int i, long v) {

        long d = v - arr[i];
        arr[i] = v;

        while (i <= n) {
            tree[i] += d;
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