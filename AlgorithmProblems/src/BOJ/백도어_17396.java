package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백도어_17396 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[] v = new boolean[n];
        long[] dist = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = st.nextToken().charAt(0) == '1';
            if (!v[i]) dist[i] = 10000000000L;
        }

        v[n - 1] = false;
        dist[n - 1] = 10000000000L;

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            if (v[a] || v[b]) continue;

            int t = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, t});
            adj[b].add(new int[] {a, t});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.distance));

        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (poll.idx == n - 1) {
                System.out.println(poll.distance);
                return;
            }

            if (v[poll.idx]) continue;
            v[poll.idx] = true;

            for (int[] next : adj[poll.idx]) {
                if (v[next[0]] || dist[next[0]] <= poll.distance + next[1]) continue;
                pq.add(new Node(next[0], poll.distance + next[1]));
            }
        }

        System.out.println(-1);
    }

    static class Node {

        int idx;
        long distance;

        public Node(int idx, long distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }
}