package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리_1197 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = ve[0], e = ve[1];

        List<int[]>[] list = new List[v + 1];
        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[edge[0]].add(new int[] {edge[1], edge[2]});
            list[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        boolean[] check = new boolean[v + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        check[1] = true;
        for (int[] edge : list[1]) {
            q.add(edge);
        }

        long sum = 0;

        while (!q.isEmpty()) {
            int[] edge = q.poll();

            if (check[edge[0]]) continue;

            check[edge[0]] = true;
            sum += edge[1];

            for (int[] nextEdge : list[edge[0]]) {
                if (!check[nextEdge[0]]) q.add(nextEdge);
            }
        }

        System.out.println(sum);
    }
}