package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SplittheSSHS3_31740 {
    static int n;
    static List<Integer>[] adj;
    static int[] weights;
    static int total;
    static boolean[] v;
    static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        weights = new int[n];
        total = 0;

        for (int i = 0; i < n; i++) {
            total += weights[i] = Integer.parseInt(br.readLine());
        }

        v = new boolean[n];

        v[0] = true;

        ans = new int[]{Integer.MAX_VALUE, 0, 0};

        sum(0);

        System.out.println(ans[0]);
        System.out.println((ans[1] + 1) + " " + (ans[2] + 1));
    }

    static int sum(int i) {

        int res = weights[i];

        for (int next : adj[i]) {
            if (v[next]) continue;

            v[next] = true;

            int sum = sum(next);
            res += sum;

            if (ans[0] > Math.abs(total - 2 * sum)) {
                ans[0] = Math.abs(total - 2 * sum);
                ans[1] = i;
                ans[2] = next;
            }
        }

        return res;
    }
}