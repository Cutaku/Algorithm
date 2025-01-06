package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class blobhyperthink_24505 {
    static int n;
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] A = new int[n][];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = new int[]{i + 1, Integer.parseInt(st.nextToken())};

        Arrays.sort(A, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int[][] tree = new int[11][n + 1];

        for (int i = 0; i < n; i++) {
            add(tree[0], A[i][0], 1);

            for (int j = 0; j < 10; j++) {
                add(tree[j + 1], A[i][0], sum(tree[j], A[i][0] - 1));
            }
        }

        System.out.println(sum(tree[10], n));
    }

    static int sum(int[] tree, int i) {

        int res = 0;

        while (i > 0) {
            res = (res + tree[i]) % d;
            i -= i & -i;
        }

        return res;
    }

    static void add(int[] tree, int i, int v) {

        while (i <= n) {
            tree[i] = (tree[i] + v) % d;
            i += i & -i;
        }
    }
}