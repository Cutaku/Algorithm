package BOJ;

import java.io.*;
import java.util.*;

public class 세금_13907 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        int[] sd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = sd[0], d = sd[1];

        City[] cities = new City[n + 1];
        for (int i = 0; i <= n; i++) cities[i] = new City();

        for (int i = 0; i < m; i++) {
            int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            cities[road[0]].next.add(new int[]{road[1], road[2]});
            cities[road[1]].next.add(new int[]{road[0], road[2]});
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2= new ArrayDeque<>();

        q1.add(s);
        cities[s].add(0, 0);

        int t = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int[] next : cities[now].next) {
                if (cities[next[0]].add(t + 1, cities[now].min[t] + next[1])) q2.add(next[0]);
            }

            if (q1.isEmpty()) {
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
                t++;
            }
        }

        City c = cities[d];

        bw.append(String.valueOf(c.minNow)).append("\n");

        for (int i = 0; i < k; i++) {
            int increase = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;

            for (int j = 0; j <= c.last; j++) {
                if (c.min[j] == 0) continue;

                c.min[j] += j * increase;
                min = Math.min(min, c.min[j]);
            }

            bw.append(String.valueOf(min)).append("\n");
        }

        bw.flush();
    }

    static class City {
        int [] min = new int[1000];
        int minNow = Integer.MAX_VALUE;
        int last;
        List<int[]> next = new ArrayList<>();

        boolean add(int t, int m) {
            if (minNow > m) {
                last = t;
                min[t] = m;
                minNow = m;
                return true;
            } else {
                return false;
            }
        }
    }
}