package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 정원정리_1772 {
    static int n, m;
    static List<Integer>[] adj;
    static int min;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        min = n;
        v = new boolean[n];

        min = Math.min(count(0)[m - 1], min);

        System.out.println(min);
    }

    static int[] count(int i) {

        v[i] = true;

        int[] dp = new int[m];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for (int child : adj[i]) {
            if (v[child]) continue;

            int[] c = count(child);

            for (int j = m - 1; j >= 0; j--) {
                dp[j]++;

                for (int k = 1; k <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k] + c[k - 1]);
                }
            }
        }

        min = Math.min(min, dp[m - 1] + 1);

        return dp;
    }
}