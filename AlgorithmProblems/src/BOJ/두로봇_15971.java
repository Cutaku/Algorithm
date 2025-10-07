package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두로봇_15971 {
    static int n, s, e;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            adj[x].add(new int[]{y, d});
            adj[y].add(new int[]{x, d});
        }

        dfs(s, -1, 0, 0);
    }

    static void dfs(int now, int before, int sum, int max) {

        if (now == e) {
            System.out.println(sum - max);
            System.exit(0);
        }

        for (int[] next : adj[now]) {
            if (next[0] == before) continue;

            dfs(next[0], now, sum + next[1], Math.max(max, next[1]));
        }
    }
}