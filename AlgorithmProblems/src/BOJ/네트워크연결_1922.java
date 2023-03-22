package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 네트워크연결_1922 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());

        List<int[]>[] list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[edge[0]].add(new int[] {edge[1], edge[2]});
            list[edge[1]].add(new int[] {edge[0], edge[2]});
        }

        boolean[] check = new boolean[n + 1];
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

        int sum = 0;

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