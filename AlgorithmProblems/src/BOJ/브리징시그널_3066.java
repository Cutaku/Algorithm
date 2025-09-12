package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 브리징시그널_3066 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            tree = new int[n + 1];

            int max = 0;

            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(br.readLine());

                int m = max(k - 1) + 1;
                update(k, m);

                max = Math.max(max, m);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void update(int i, int m) {

        while (i <= n) {
            tree[i] = Math.max(tree[i], m);
            i += i & -i;
        }
    }

    static int max(int i) {

        int res = 0;

        while (i > 0) {
            res = Math.max(res, tree[i]);
            i -= i & -i;
        }

        return res;
    }
}