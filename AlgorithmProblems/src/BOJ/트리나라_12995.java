package BOJ;

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

        v = new boolean[n];
        ans = 0;

        count(0);

        System.out.println(ans);
    }

    static long[] count(int idx) {

        v[idx] = true;

        long[] res = new long[k];
        res[0] = 1;

        for (int c : adj[idx]) {
            if (v[c]) continue;

            long[] dp = count(c);

            for (int i = k - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    res[i] += res[j] * dp[i - j - 1];
                    res[i] %= d;
                }
            }
        }

        ans += res[k - 1];
        ans %= d;

        return res;
    }
}