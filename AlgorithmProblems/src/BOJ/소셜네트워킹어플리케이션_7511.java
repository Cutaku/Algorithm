package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소셜네트워킹어플리케이션_7511 {
    static int[] root;
    static int n, k, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("Scenario ").append(t).append(":\n");

            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());

            root = new int[n];
            for (int i = 1; i < n; i++) root[i] = i;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));

                if (a > b)  root[a] = b;
                else if (a < b) root[b] = a;
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));

                sb.append(a == b ? 1 : 0).append("\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}