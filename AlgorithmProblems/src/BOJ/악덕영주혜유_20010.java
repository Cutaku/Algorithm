package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 악덕영주혜유_20010 {
    static int n, k;
    static int[] root;
    static List<int[]>[] adj;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        int component = n;
        long ans = 0;

        while (component > 1) {
            int[] poll = pq.poll();
            int a = find(poll[0]), b = find(poll[1]);

            if (a == b) continue;

            root[Math.max(a, b)] = Math.min(a, b);
            component--;
            ans += poll[2];

            adj[poll[0]].add(new int[]{poll[1], poll[2]});
            adj[poll[1]].add(new int[]{poll[0], poll[2]});
        }

        System.out.println(ans);

        Pair p = farthest(0);
        p = farthest(p.idx);

        System.out.println(p.dist);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    static Pair farthest(int s) {

        Pair res = new Pair(s, 0);
        Queue<Pair> q = new ArrayDeque<>();
        boolean[] v = new boolean[n];

        q.add(res);
        v[s] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (p.dist > res.dist) res = p;

            for (int[] next : adj[p.idx]) {
                if (v[next[0]]) continue;

                q.add(new Pair(next[0], p.dist + next[1]));
                v[next[0]] = true;
            }
        }

        return res;
    }

    static class Pair {

        int idx;
        long dist;

        public Pair(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}