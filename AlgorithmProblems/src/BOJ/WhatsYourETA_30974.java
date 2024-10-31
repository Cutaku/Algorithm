package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WhatsYourETA_30974 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotPrime = new boolean[10000001];

        for (int i = 2; i * i < 10000001; i++) {
            if (isNotPrime[i]) continue;

            for (int j = 2; i * j < 10000001; j++) {
                isNotPrime[i * j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] codes = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) codes[i] = Integer.parseInt(st.nextToken());

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            if (isNotPrime[codes[u] + codes[v]]) continue;

            adj[u].add(new int[] {v, w});
            adj[v].add(new int[] {u, w});
        }

        PriorityQueue<Station> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));

        long[] min = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);

        pq.add(new Station(0, 0));
        min[0] = 0;

        while (!pq.isEmpty()) {
            Station now = pq.poll();

            if (now.num == n - 1) {
                System.out.println(now.dist);
                return;
            }

            if (now.dist > min[now.num]) continue;

            for (int[] next : adj[now.num]) {
                if (now.dist + next[1] >= min[next[0]]) continue;
                min[next[0]] = now.dist + next[1];

                pq.add(new Station(next[0], now.dist + next[1]));
            }
        }

        System.out.println("Now where are you?");
    }

    static class Station {
        int num;
        long dist;

        public Station(int num, long dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}