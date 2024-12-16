import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리나라_12995 {
    static int n, k;
    static int d = 1000000007;
    static List<Integer>[] adj;
    static long[][] tree;
    static boolean[] v;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        tree = new long[n][k];
        for (int i = 0; i < n; i++) tree[i][0] = 1;

        v = new boolean[n];
        ans = 0;

        count(0);

        System.out.println(ans);
    }

    static void count(int idx) {

        v[idx] = true;

        for (int c : adj[idx]) {
            if (v[c]) continue;

            count(c);

            long[] tmp = tree[idx].clone();

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < i; j++) {
                    tmp[i] += tree[idx][j] * tree[c][i - j - 1];
                    tmp[i] %= d;
                }
            }

            tree[idx] = tmp;
        }

        ans += tree[idx][k - 1];
        ans %= d;
    }
}