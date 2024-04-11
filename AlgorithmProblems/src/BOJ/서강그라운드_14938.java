package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서강그라운드_14938 {
    static int n, m, r;
    static int[] items;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            adj[v1].add(new int[] { v2, d });
            adj[v2].add(new int[] { v1, d });
        }

        int max = 0;

        for (int i = 0; i < n; i++)
            max = Math.max(max, dijkstra(i));

        System.out.println(max);
    }

    static int dijkstra(int s) {

        int[] minDist = new int[n];
        Arrays.fill(minDist, 2000);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        minDist[s] = 0;
        pq.add(new int[] { s, 0 });

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            if (minDist[poll[0]] < poll[1])
                continue;
            for (int i = 0; i < adj[poll[0]].size(); i++) {
                int[] a = adj[poll[0]].get(i);

                if (minDist[a[0]] > minDist[poll[0]] + a[1]) {
                    minDist[a[0]] = minDist[poll[0]] + a[1];
                    pq.add(new int[] { a[0], minDist[poll[0]] + a[1] });
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (minDist[i] <= m)
                sum += items[i];
        }

        return sum;
    }
}
