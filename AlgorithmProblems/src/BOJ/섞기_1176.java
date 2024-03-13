package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 섞기_1176 {
    static long[][] memo;
    static int n, k, m;
    static int[] height;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = 1 << n;

        height = new int[m];

        for (int i = 0; i < n; i++) {
            height[1 << i] = Integer.parseInt(br.readLine());
        }

        map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(1 << i, i);

        memo = new long[m][n];

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += dfs(1 << i, 1 << i, i);
        }

        System.out.println(ans);
    }

    static long dfs(int used, int last, int i) {

        if (used == m - 1) return 1;

        if (memo[used][i] > 0) return memo[used][i];

        int able = (m - 1) & ~used;

        long res = 0;

        while (able > 0) {
            int p = able & -able;
            able -= p;

            if (Math.abs(height[last] - height[p]) > k) res += dfs(used | p, p, map.get(p));
        }

        return memo[used][i] = res;
    }
}