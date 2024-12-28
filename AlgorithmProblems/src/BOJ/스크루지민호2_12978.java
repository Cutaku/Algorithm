package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 스크루지민호2_12978 {
    static List<Integer>[] adj;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        v = new boolean[n];

        int[] res = count(0);

        System.out.println(Math.min(res[0], res[1]));
    }

    static int[] count(int i) {

        v[i] = true;

        int[] res = new int[]{1, 0};

        for (int c : adj[i]) {
            if (v[c]) continue;

            int[] r = count(c);

            res[0] += Math.min(r[0], r[1]);
            res[1] += r[0];
        }

        return res;
    }
}