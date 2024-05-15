package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 불우이웃돕기_1414 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        root = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;

            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                int v;

                if (c == '0') {
                    continue;
                } else if (c <= 'Z') {
                    v = c - 'A' + 27;
                } else {
                    v = c - 'a' + 1;
                }

                sum += v;

                if (i != j) pq.add(new int[]{i, j, v});
            }
        }

        int count = 0;

        while (!pq.isEmpty() && count < n - 1) {
            int[] edge = pq.poll();

            int a = find(edge[0]);
            int b = find(edge[1]);

            if (a != b) {
                root[Math.max(a, b)] = Math.min(a, b);
                count++;
                sum -= edge[2];
            }
        }

        if (count == n - 1) System.out.println(sum);
        else System.out.println(-1);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}