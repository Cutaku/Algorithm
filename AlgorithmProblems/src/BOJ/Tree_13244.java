package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tree_13244 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            boolean isTree = true;

            if (m != n - 1) {
                isTree = false;
            } else {
                root = new int[n];
                for (int i = 0; i < n; i++) root[i] = i;

                while (m-- > 0) {
                    st = new StringTokenizer(br.readLine());

                    int a = find(Integer.parseInt(st.nextToken()) - 1);
                    int b = find(Integer.parseInt(st.nextToken()) - 1);

                    if (a == b) {
                        isTree = false;
                        break;
                    }

                    root[Math.max(a, b)] = Math.min(a, b);
                }
            }

            for (int i = 0; i < m; i++) br.readLine();

            sb.append(isTree ? "tree\n" : "graph\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}