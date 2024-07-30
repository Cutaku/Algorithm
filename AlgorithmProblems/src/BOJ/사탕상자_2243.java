package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사탕상자_2243 {
    static int n, max;
    static int[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        max = 1000000;
        tree = new int[max + 1];

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().charAt(0) == '1') {
                int i = find(Integer.parseInt(st.nextToken()));

                sb.append(i).append("\n");
                modify(i, -1);
            } else {
                modify(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
    }

    static void modify(int i, int d) {

        while (i <= max) {
            tree[i] += d;
            i += i & -i;
        }
    }

    static int count(int i) {

        int res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }

    static int find(int num) {

        if (tree[1] >= num) return 1;

        int s = 1, e = max;

        while (e - s > 1) {
            int m = (e + s) >> 1;

            if (count(m) < num) s = m;
            else e = m;
        }

        return e;
    }
}