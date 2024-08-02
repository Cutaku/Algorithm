package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영화수집_3653 {
    static int n, m;
    static int[] idx, tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            idx = new int[n];
            tree = new int[n + m + 1];

            for (int i = 1; i <= n; i++) {
                idx[n - i] = i;
                tree[i] = i & -i;
            }

            for (int i = n + 1; i <= n + m; i++) {
                tree[i] = Math.max(0, (i & -i) - i + n);
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                int i = Integer.parseInt(st.nextToken());

                sb.append(n - sum(idx[i - 1])).append(" ");
                modify(idx[i - 1], - 1);
                modify(n + j, 1);

                idx[i - 1] = n + j;
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void modify(int i, int d) {

        while (i <= n + m) {
            tree[i] += d;
            i += i & -i;
        }
    }

    static int sum(int i) {

        int res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}