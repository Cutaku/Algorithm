package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도로포장_1162 {
    static final long max = 10000000000L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        City[] cities = new City[n];
        for (int i = 0; i < n; i++) cities[i] = new City(i, k);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken()) - 1, c2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            cities[c1].next.add(new int[]{c2, cost});
            cities[c2].next.add(new int[]{c1, cost});
        }

        cities[0].min[0] = 0;

        boolean[] v = new boolean[n];

        for (int i = 0; i <= k; i++) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(c -> c[1]));

            for (City city : cities) {
                pq.add(new long[]{city.cNum, city.min[i]});
            }

            int count = 0;

            while (count < n - 1 && !pq.isEmpty()) {
                long[] arr = pq.poll();

                City now = cities[(int) arr[0]];

                if (v[now.cNum]) continue;
                if (now.min[i] == max) break;

                v[now.cNum] = true;

                count++;

                if (i < k) now.min[i + 1] = Math.min(now.min[i], now.min[i + 1]);

                for (int[] next : now.next) {
                    City nextCity = cities[next[0]];

                    if (!v[nextCity.cNum] && nextCity.min[i] > now.min[i] + next[1]) {
                        nextCity.min[i] = now.min[i] + next[1];
                        pq.add(new long[]{nextCity.cNum, nextCity.min[i]});
                    }

                    if (i < k) nextCity.min[i + 1] = Math.min(nextCity.min[i + 1], now.min[i]);
                }
            }

            Arrays.fill(v, false);
        }

        System.out.println(cities[n - 1].min[k]);
    }

    static class City {
        int cNum;
        List<int[]> next = new ArrayList<>();
        long[] min;

        public City(int cNum, int k) {
            this.cNum = cNum;
            this.min = new long[k + 1];
            Arrays.fill(this.min, max);
        }
    }
}