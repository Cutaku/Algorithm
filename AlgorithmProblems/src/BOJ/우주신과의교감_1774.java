package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우주신과의교감_1774 {
    static int[] roots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;

        int[][] cords = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cords[i][0] = Integer.parseInt(st.nextToken());
            cords[i][1] = Integer.parseInt(st.nextToken());
        }

        int union = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = find(Integer.parseInt(st.nextToken()) - 1);
            int v2 = find(Integer.parseInt(st.nextToken()) - 1);

            if (v1 != v2) {
                roots[Math.max(v1, v2)] = Math.min(v1, v2);
                union++;
            }
        }

        if (union == n - 1) {
            System.out.println("0.00");
            return;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.distance));

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (find(i) != find(j)) {
                    long x1 = cords[i][0], y1 = cords[i][1];
                    long x2 = cords[j][0], y2 = cords[j][1];
                    long d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

                    pq.add(new Edge(i, j, d));
                }
            }
        }

        double ans = 0;

        while (!pq.isEmpty() && union < n - 1) {
            Edge poll = pq.poll();

            int r1 = find(poll.v1), r2 = find(poll.v2);

            if (r1 != r2) {
                ans += Math.sqrt(poll.distance);

                roots[Math.max(r1, r2)] = Math.min(r1, r2);
                union++;
            }
        }

        System.out.printf("%.2f", ans);
    }

    static int find(int a) {

        if (a == roots[a]) return a;
        return roots[a] = find(roots[a]);
    }

    static class Edge {
        int v1, v2;
        long distance;

        public Edge(int v1, int v2, long distance) {
            this.v1 = v1;
            this.v2 = v2;
            this.distance = distance;
        }
    }
}