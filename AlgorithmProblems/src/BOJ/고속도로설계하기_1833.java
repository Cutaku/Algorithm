package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 고속도로설계하기_1833 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] costs = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int j = i + 1; j < n; j++) {
                if (costs[j] > 0) pq.add(new int[]{i, j, costs[j]});
                else {
                    int a = find(i);
                    int b = find(j);

                    if (a != b) count++;

                    root[Math.max(a, b)] = Math.min(a, b);
                    sum -= costs[j];
                }
            }
        }

        List<int[]> roads = new ArrayList<>();

        while (count < n - 1) {
            int[] poll = pq.poll();

            int a = find(poll[0]);
            int b = find(poll[1]);

            if (a == b) continue;

            roads.add(new int[]{poll[0] + 1, poll[1] + 1});

            root[Math.max(a, b)] = Math.min(a, b);
            sum += poll[2];
            count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append(" ").append(roads.size()).append("\n");

        for (int[] road : roads) {
            sb.append(road[0]).append(" ").append(road[1]).append("\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}