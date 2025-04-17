package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 슬슬가지를먹지않으면죽는다_27945 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[][] edges = new int[n - 1][];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken()) - 1;

            if (t > n - 2) continue;

            edges[t] = new int[] {u, v};
        }

        for (int i = 0; i < n - 1; i++) {
            if (edges[i] == null) {
                System.out.println(i + 1);
                return;
            }

            int a = find(edges[i][0]);
            int b = find(edges[i][1]);

            if (a == b) {
                System.out.println(i + 1);
                return;
            }

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(n);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}