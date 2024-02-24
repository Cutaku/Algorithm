package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성터널_2887 {
    static int[] roots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] xSort = new int[n][];
        int[][] ySort = new int[n][];
        int[][] zSort = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int[] planet = new int[4];
            planet[0] = i;
            for (int j = 1; j < 4; j++) planet[j] = Integer.parseInt(st.nextToken());

            xSort[i] = planet;
            ySort[i] = planet;
            zSort[i] = planet;
        }

        Arrays.sort(xSort, Comparator.comparingInt(p -> p[1]));
        Arrays.sort(ySort, Comparator.comparingInt(p -> p[2]));
        Arrays.sort(zSort, Comparator.comparingInt(p -> p[3]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));

        for (int i = 1; i < n; i++) {
            pq.add(new int[]{xSort[i][0], xSort[i - 1][0], xSort[i][1] - xSort[i - 1][1]});
            pq.add(new int[]{ySort[i][0], ySort[i - 1][0], ySort[i][2] - ySort[i - 1][2]});
            pq.add(new int[]{zSort[i][0], zSort[i - 1][0], zSort[i][3] - zSort[i - 1][3]});
        }

        roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;

        int sum = 0;
        int count = 0;

        while (count < n - 1 && !pq.isEmpty()) {
            int[] edge = pq.poll();

            int p1 = find(edge[0]);
            int p2 = find(edge[1]);

            if (p1 == p2) continue;

            sum += edge[2];
            count++;

            roots[Math.max(p1, p2)] = Math.min(p1, p2);
        }

        System.out.println(sum);
    }

    static int find(int x) {
        if (x == roots[x]) return x;
        else return roots[x] = find(roots[x]);
    }
}