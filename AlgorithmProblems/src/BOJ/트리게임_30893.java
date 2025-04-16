package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리게임_30893 {
    static List<Integer>[] adj;
    static int s, e;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, s, -1);

        System.out.println("Second");
    }

    static void dfs(int d, int a, int b) {

        if (a == e) {
            System.out.println("First");
            System.exit(0);
        }

        if (d % 2 == 1 && adj[a].size() > 2) return;

        for (int c : adj[a]) {
            if (c == b) continue;

            dfs(d + 1, c, a);
        }
    }
}