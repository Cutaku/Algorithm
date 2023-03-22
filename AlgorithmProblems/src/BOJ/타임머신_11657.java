package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 타임머신_11657 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edges.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int limit = 60000000;

        long[] dist = new long[n + 1];
        Arrays.fill(dist, limit);
        dist[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int time = edge[2];

                if (dist[from] == limit) continue;

                dist[to] = Math.min(dist[to], dist[from] + time);
            }
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int time = edge[2];

            if (dist[from] == limit) continue;

            if (dist[to] > dist[from] + time) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i < n + 1; i++) {
            if (dist[i] == limit) System.out.println(-1);
            else System.out.println(dist[i]);
        }
    }
}