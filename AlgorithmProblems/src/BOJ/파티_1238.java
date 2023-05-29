package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 파티_1238 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmx[0], m = nmx[1], x = nmx[2];

        List<int[]>[] adj = new List[n + 1];
        List<int[]>[] adj_r = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            adj_r[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[route[0]].add(new int[]{route[1], route[2]});
            adj_r[route[1]].add(new int[]{route[0], route[2]});
        }

        int[] timesToParty = findTimes(adj_r, x);
        int[] timesToHome = findTimes(adj, x);

        int max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, timesToParty[i] + timesToHome[i]);
        }

        System.out.println(max);
    }

    public static int[] findTimes(List<int[]>[] adj, int x) {

        int n = adj.length - 1;

        int[] times = new int[n + 1];
        Arrays.fill(times, 1000000);

        boolean[] checked = new boolean[n + 1];

        times[x] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minInd = findMinInd(times, checked);
            checked[minInd] = true;

            for (int[] route : adj[minInd]) {
                times[route[0]] = Math.min(times[route[0]], times[minInd] + route[1]);
            }
        }

        return times;
    }

    public static int findMinInd(int[] times, boolean[] checked) {

        int result = 0;
        int min = 1000000;

        for (int i = 0; i < times.length; i++) {
            if (checked[i]) continue;

            if (times[i] < min) {
                result = i;
                min = times[i];
            }
        }

        return result;
    }
}