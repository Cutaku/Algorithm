package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_3584 {
    static int[] bitToNum;
    static int n, root;
    static int[][] ancestors;
    static int[] depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        bitToNum = new int[8193];
        for (int i = 1; i < 14; i++) bitToNum[1 << i] = i;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            ancestors = new int[n + 1][14];
            depth = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                ancestors[child][0] = parent;
            }

            root = 0;

            for (int i = 1; i <= n; i++) {
                if (ancestors[i][0] == 0) {
                    root = i;
                    break;
                }
            }

            for (int i = 1; i <= n; i++) findDepth(i);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; (1 << j) <= depth[i]; j++) {
                    findAncestor(i, j);
                }
            }

            st = new StringTokenizer(br.readLine());

            sb.append(findLCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int findLCA(int a, int b) {

        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        int d = depth[a] - depth[b];

        while (d > 0) {
            int p = d & -d;
            d -= p;

            a = ancestors[a][bitToNum[p]];
        }

        while (a != b) {
            int i = 0;

            while (i < 13 && ancestors[a][i + 1] != ancestors[b][i + 1]) i++;

            a = ancestors[a][i];
            b = ancestors[b][i];
        }

        return a;
    }

    static int findDepth(int i) {

        if (i == root) return 0;

        if (depth[i] > 0) return depth[i];

        return depth[i] = findDepth(ancestors[i][0]) + 1;
    }

    static int findAncestor(int a, int i) {

        if (ancestors[a][i] > 0) return ancestors[a][i];

        return ancestors[a][i] = findAncestor(findAncestor(a, i - 1), i - 1);
    }
}