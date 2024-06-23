package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 면접보는승범이네_17835 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken()) - 1;
            int from = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            adj[from].add(new int[]{to, d});
        }

        long[] min = new long[n];
        Arrays.fill(min, 10000000000L);

        PriorityQueue<Distance> pq = new PriorityQueue<>(Comparator.comparingLong(d -> d.minDistance));

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int city = Integer.parseInt(st.nextToken()) - 1;

            min[city] = 0;

            for (int[] road : adj[city]) {
                pq.add(new Distance(road[0], road[1]));
            }
        }

        while (!pq.isEmpty()) {
            Distance distance = pq.poll();

            if (min[distance.cityNum] <= distance.minDistance) continue;
            min[distance.cityNum] = distance.minDistance;

            for (int[] road : adj[distance.cityNum]) {
                if (min[road[0]] > min[distance.cityNum] + road[1]) {
                    pq.add(new Distance(road[0], min[distance.cityNum] + road[1]));
                }
            }
        }

        int farCity = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            if (max < min[i]) {
                farCity = i + 1;
                max = min[i];
            }
        }

        System.out.println(farCity);
        System.out.println(max);
    }

    static class Distance {
        int cityNum;
        long minDistance;

        public Distance(int cityNum, long minDistance) {
            this.cityNum = cityNum;
            this.minDistance = minDistance;
        }
    }
}