package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 팩트는트리가건강해지고있다는거임_32521 {
    static int n, k;
    static List<Integer>[] adj;
    static int[] rotten;
    static int ans;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        rotten = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) rotten[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        ans = 0;

        count(-1, 0);

        System.out.println(ans);
    }

    static int count(int b, int u) {

        int res = rotten[u];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int v : adj[u]) {
            if (v == b) continue;

            int c = count(u, v);

            res += c;
            pq.add(c);
        }

        while (res > k) {
            res -= pq.poll();
            ans++;
        }

        return res;
    }
}