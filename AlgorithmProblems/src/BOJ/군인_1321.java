package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 군인_1321 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            modify(i, Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                modify(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(find(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void modify(int i, int d) {

        while (i <= n) {
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

    static int find(int i) {

        if (tree[1] >= i) return 1;

        int s = 1, e = n;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (sum(m) < i) s = m;
            else e = m;
        }

        return e;
    }
}