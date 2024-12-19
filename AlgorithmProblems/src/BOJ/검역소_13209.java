package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 검역소_13209 {
    static int n, k;
    static long max;
    static long[] population;
    static List<Integer>[] adj;
    static int count;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            population = new long[n];
            max = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                population[i] = Long.parseLong(st.nextToken());
                max = Math.max(max, population[i]);
            }

            adj = new List[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                adj[a].add(b);
                adj[b].add(a);
            }

            long s = max - 1, e = n * 1000000000L;

            while (e - s > 1) {
                long m = (s + e) >> 1;

                if (check(m)) e = m;
                else s = m;
            }

            sb.append(e).append("\n");
        }

        System.out.println(sb);
    }

    static boolean check(long m) {

        count = 0;
        v = new boolean[n];

        dp(0, m);

        return count <= k;
    }

    static long dp(int i, long m) {

        v[i] = true;

        long res = population[i];

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int child : adj[i]) {
            if (v[child]) continue;

            pq.add(dp(child, m));
        }

        while (!pq.isEmpty() && res + pq.peek() <= m) {
            res += pq.poll();
        }

        count += pq.size();

        return res;
    }
}