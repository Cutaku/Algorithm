package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 현대모비스와함께하는편안한주행_32388 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        long[][] signs = new long[n + 2][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            signs[i][0] = Long.parseLong(st.nextToken());
            signs[i][1] = Long.parseLong(st.nextToken());
        }

        signs[n + 1][0] = a;
        signs[n + 1][1] = b;

        PriorityQueue<Distance> pq = new PriorityQueue<>(Comparator.comparingDouble(d -> d.dist));

        double[] min = new double[n + 2];
        Arrays.fill(min, 10000000000D);

        pq.add(new Distance(0, 0, 0));
        min[0] = 0;

        boolean[] v = new boolean[n + 2];

        while (!pq.isEmpty()) {
            Distance now = pq.poll();

            if (now.to == n + 1) {
                System.out.println(now.dist);
                return;
            }

            if (v[now.to]) continue;
            v[now.to] = true;

            for (int i = 0; i < n + 2; i++) {
                if (i == now.to) continue;

                double d = distance(signs[i][0], signs[i][1], signs[now.to][0], signs[now.to][1]);

                if (i != 0 && i != n + 1) d -= 1;
                if (now.to != 0 && now.to != n + 1) d -= 1;

                d = Math.max(0, d);

                if (min[i] > now.dist + d) {
                    min[i] = now.dist + d;
                    pq.add(new Distance(0, i, now.dist + d));
                }
            }
        }
    }

    static double distance(long x1, long y1, long x2, long y2) {

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    static class Distance {

        int from, to;
        double dist;

        public Distance(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}