package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의가중치_1289 {
    static int n;
    static int d = 1000000007;
    static int half = 500000004;
    static List<int[]>[] adj;
    static boolean[] v;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b, w});
            adj[b].add(new int[]{a, w});
        }

        v = new boolean[n];
        ans = 0;

        count(0);

        ans = (ans + d) % d;

        System.out.println(ans);
    }

    static long count(int idx) {

        v[idx] = true;

        long res = 0;
        long square = 0;

        for (int[] child : adj[idx]) {
            if (v[child[0]]) continue;

            long sum = child[1] * (1 + count(child[0])) % d;

            res += sum;
            res %= d;

            square += sum * sum;
            square %= d;
        }

        ans += (res * res - square) % d * half + res;
        ans %= d;

        return res;
    }
}