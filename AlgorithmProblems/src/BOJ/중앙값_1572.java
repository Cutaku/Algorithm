package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 중앙값_1572 {
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int m = (k + 1) >> 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine()) + 1;

        tree = new int[65538];

        for (int i = 0; i < k; i++) modify(arr[i], 1);

        long res = find(m);

        for (int i = 0; i < n - k; i++) {
            modify(arr[i], -1);
            modify(arr[i + k], 1);

            res += find(m);
        }

        System.out.println(res);
    }

    static void modify(int i, int d) {

        while (i < 65538) {
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

        if (tree[1] >= i) return 0;

        int s = 1, e = 65537;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (sum(m) < i) s = m;
            else e = m;
        }

        return s;
    }
}