package BOJ;

import java.io.*;
import java.util.*;

public class 택배_1719 {
    static int n;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int m = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            adj[d].add(new int[]{e, l});
            adj[e].add(new int[]{d, l});
        }

        int[] A = dijkstra(a);
        int[] B = dijkstra(b);
        int[] C = dijkstra(c);

        int max = 0;
        int mIdx = 0;

        for (int i = 0; i < n; i++) {
            if (i == a || i == b || i == c) continue;
            if (max < Math.min(Math.min(A[i], B[i]), C[i])) {
                max = Math.min(Math.min(A[i], B[i]), C[i]);
                mIdx = i + 1;
            }
        }

        System.out.println(mIdx);
    }

    static int[] dijkstra(int s) {

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] v = new boolean[n];

        pq.add(new int[]{s, 0});

        int count = 0;

        while (!pq.isEmpty() && count < n) {
            int[] now = pq.poll();

            if (v[now[0]] || res[now[0]] < now[1]) continue;

            res[now[0]] = now[1];
            v[now[0]] = true;
            count++;

            for (int[] next : adj[now[0]]) {
                if (v[next[0]] || res[next[0]] <= now[1] + next[1]) continue;

                res[next[0]] = now[1] + next[1];
                pq.add(new int[]{next[0], now[1] + next[1]});
            }
        }

        return res;
    }
}