package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 도시분할계획_1647 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nm[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] roads = new int[m][];
        for (int i = 0; i < m; i++) roads[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(roads, Comparator.comparingInt(r -> r[2]));

        int[] roots = new int[n + 1];
        for (int i = 0; i <= n; i++) roots[i] = i;

        int sum = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (count == n - 2) break;

            int[] road = roads[i];

            int a = road[0];
            int b = road[1];
            int cost = road[2];

            if (union(a, b, roots)) {
                sum += cost;
                count++;
            }
        }

        System.out.println(sum);
    }

    public static boolean union(int a, int b, int[] roots) {

        while (a != roots[a]) a = roots[a];
        while (b != roots[b]) b = roots[b];

        if (a == b) {
            return false;
        } else {
            roots[Math.max(a, b)] = Math.min(a, b);
            return true;
        }
    }
}