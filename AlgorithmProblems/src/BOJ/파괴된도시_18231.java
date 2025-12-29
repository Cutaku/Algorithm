package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 파괴된도시_18231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        int k = Integer.parseInt(br.readLine());
        boolean[] destroy = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            destroy[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        List<Integer> ans = new ArrayList<>();

        a: for (int i = 0; i < n; i++) {
            if (!destroy[i]) continue;

            for (int j : adj[i]) {
                if (!destroy[j]) continue a;
            }

            ans.add(i);
        }

        for (int i : ans) {
            if (destroy[i]) {
                k--;
                destroy[i] = false;
            }

            for (int j : adj[i]) {
                if (destroy[j]) {
                    k--;
                    destroy[j] = false;
                }
            }
        }

        if (k > 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append(ans.size()).append("\n");

            for (int a : ans) {
                sb.append(a + 1).append(" ");
            }

            System.out.println(sb);
        }
    }
}