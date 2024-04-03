package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가계부_Hard_12837 {
    static int n, q;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        tree = new long[n + 1];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("1")) {
                modify(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(-sum(Integer.parseInt(st.nextToken()) - 1) + sum(Integer.parseInt(st.nextToken()))).append("\n");
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

    static long sum(int i) {

        long sum = 0;

        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}