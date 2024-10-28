package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 대전도시철도2호선_32408 {
    static int n;
    static List<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        visit = new boolean[n];
        visit[0] = true;

        init(0);

        long sum = 0;
        long sSum = 0;

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                for (int next : adj[i]) {
                    if (visit[next]) continue;
                    visit[next] = true;

                    long s = dfs(next);
                    sum += s;
                    sSum += s * s;
                }
            }
        }

        System.out.println((sum * sum - sSum) / 2);
    }

    static void init(int v) {

        if (v == n - 1) {
            return;
        }

        for (int next : adj[v]) {
            if (!visit[next]) {
                visit[next] = true;
                init(next);

                if (visit[n - 1]) return;
                visit[next] = false;
            }
        }
    }

    static long dfs(int v) {

        long res = 1;

        for (int next : adj[v]) {
            if (visit[next]) continue;

            visit[next] = true;

            res += dfs(next);
        }

        return res;
    }
}