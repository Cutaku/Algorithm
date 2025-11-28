package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리와수열_26159 {
    static int n;
    static List<Integer>[] adj;
    static long[] cnt;
    static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        cnt = new long[n];
        idx = 0;

        count(0, -1);
        Arrays.sort(cnt);

        long[] arr = new long[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        long res = 0;
        long d = 1000000007;

        for (int i = 1; i < n; i++) {
            res = (res + cnt[n - i] % d * arr[i - 1]) % d;
        }

        System.out.println(res);
    }

    static int count(int node, int b) {

        int res = 1;

        for (int child : adj[node]) {
            if (child == b) continue;

            res += count(child, node);
        }

        cnt[idx++] = (long) res * (n - res);

        return res;
    }
}