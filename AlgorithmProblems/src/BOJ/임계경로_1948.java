package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 임계경로_1948 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] routes = new int[m][];

        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            routes[i] = route;

            adj[route[0]].add(i);
        }

        int[] se = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = se[0], e = se[1];

        City[] cities = new City[n + 1];
        for (int i = 0; i <= n; i++) cities[i] = new City();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);

        while (!q.isEmpty()) {
            int i = q.poll();

            City now = cities[i];

            for (int r : adj[i]) {
                int[] route = routes[r];

                City next = cities[route[1]];

                if (next.max < now.max + route[2]) {
                    next.max = now.max + route[2];
                    next.before.clear();
                    next.before.add(r);
                    q.add(route[1]);
                } else if (next.max == now.max + route[2]) {
                    next.before.add(r);
                }
            }
        }

        System.out.println(cities[e].max);

        boolean[] noRest = new boolean[m];

        q.add(e);

        boolean[] v = new boolean[n + 1];

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int r : cities[now].before) {
                noRest[r] = true;

                if (v[routes[r][0]]) continue;

                v[routes[r][0]] = true;

                q.add(routes[r][0]);
            }
        }

        int count = 0;

        for (boolean b : noRest) {
            if (b) count++;
        }

        System.out.println(count);
    }

    static class City {
        List<Integer> before = new ArrayList<>();
        int max = 0;
    }
}