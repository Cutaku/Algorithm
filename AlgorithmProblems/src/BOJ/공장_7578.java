package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공장_7578 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        int[] idx = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            idx[Integer.parseInt(st.nextToken())] = i;
        }

        long res = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int j = idx[Integer.parseInt(st.nextToken())];

            res += i - sum(j);
            add(j);
        }

        System.out.println(res);
    }

    static void add(int i) {

        while (i <= n) {
            tree[i]++;
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