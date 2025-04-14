package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static List<Integer>[] adj;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }

        System.out.println(0);
    }

    static void dfs(int d, int i) {

        if (d == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (int j : adj[i]) {
            if (v[j]) continue;

            v[j] = true;
            dfs(d + 1, j);
            v[j] = false;
        }
    }
}