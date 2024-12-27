package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 민준이와마산그리고건우_18223 {
    static int v;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()) - 1;

        adj = new List[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        int[] d1 = dijstra(0, v - 1);

        if (d1[p] == 50000001) {
            System.out.println("GOOD BYE");
            return;
        }

        int[] d2 = dijstra(p, v - 1);

        System.out.println(d1[v - 1] == d1[p] + d2[v - 1] ? "SAVE HIM" : "GOOD BYE");
    }

    static int[] dijstra(int s, int e) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{s, 0});

        int[] res = new int[v];
        Arrays.fill(res, 50000001);

        res[s] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (poll[0] == e) return res;

            if (res[poll[0]] < poll[1]) continue;

            for (int[] next : adj[poll[0]]) {
                if (res[next[0]] <= poll[1] + next[1]) continue;

                res[next[0]] = poll[1] + next[1];

                pq.add(new int[]{next[0], res[next[0]]});
            }
        }

        return res;
    }
}