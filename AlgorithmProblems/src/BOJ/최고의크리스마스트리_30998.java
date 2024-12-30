package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최고의크리스마스트리_30998 {
    static int n;
    static long[] factorial;
    static long[] rFactorial;
    static int[] edges;
    static long[] dp;
    static int[] subTree;
    static List<Integer>[] adj;
    static Map<Long, Long> map;
    static Memo[] memos = new Memo[n];
    static final int d = 998244353;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        init();

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;

            edges[2 * i] = v;
            edges[2 * i + 1] = u;

            adj[u].add(2 * i);
            adj[v].add(2 * i + 1);
        }


        for (int i = 0; i < n; i++) {
            count(-1, i + 2 * n - 2);
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            sb.append(dp[2 * n + Integer.parseInt(br.readLine()) - 3]).append("\n");
        }

        System.out.println(sb);
    }

    static void init() {

        factorial = new long[n + 1];
        rFactorial = new long[n + 1];

        factorial[0] = 1;
        rFactorial[0] = 1;
        factorial[1] = 1;
        rFactorial[1] = 1;
        map = new HashMap<>();
        memos = new Memo[n];

        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i % d;
            rFactorial[i] = rFactorial[i - 1] * reverse(i) % d;
        }

        edges = new int[3 * n - 2];
        dp = new long[3 * n - 2];
        subTree = new int[3 * n - 2];
        adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            edges[i + 2 * n - 2] = i;
        }
    }

    static long count(int from, int e) {

        if (dp[e] > 0) return dp[e];

        int r = edges[e];

        if (memos[r] == null) {
            long res = 1L;

            int sum = 0;

            Memo memo = new Memo();

            for (int edge : adj[r]) {
                if (edges[edge] == from) {
                    memo.except = edge;
                    continue;
                }

                res = res * count(r, edge) % d;
                res = res * rFactorial[subTree[edge]] % d;

                sum += subTree[edge];
            }

            subTree[e] = sum + 1;
            memo.res = res * rFactorial[n - subTree[e]] % d;
            memos[r] = memo;

            return dp[e] = res * factorial[sum] % d;
        } else {
            Memo memo = memos[r];

            long res = memo.res;

            if (memo.except != null) {
                res = res * count(r, memo.except) % d;
                memo.res = res;
                memo.except = null;
            }

            if (from > -1) {
                int edge = e % 2 == 0 ? e + 1 : e - 1;

                res = res * factorial[subTree[edge]] % d;
                res = res * factorial[n - subTree[edge] - 1] % d;
                res = res * reverse(count(r, edge)) % d;
            } else {
                res = res * factorial[n - 1] % d;
            }

            return dp[e] = res;
        }
    }

    static long reverse(long a) {

        if (map.containsKey(a)) return map.get(a);

        int p = d - 2;
        long res = 1;
        long b = a;

        while (p > 0) {
            if (p % 2 == 0) {
                b = b * b % d;
                p /= 2;
            } else {
                res = res * b % d;
                p--;
            }
        }

        map.put(a, res);

        return res;
    }

    static class Memo {

        Long res;
        Integer except;
    }
}