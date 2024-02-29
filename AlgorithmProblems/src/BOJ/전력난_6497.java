package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전력난_6497 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == 0) break;

            int sum = 0;

            root = new int[m];
            for (int i = 0; i < m; i++) root[i] = i;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int[] e = new int[3];

                for (int j = 0; j < 3; j++) {
                    e[j] = Integer.parseInt(st.nextToken());
                }

                sum += e[2];

                pq.add(e);
            }

            int count = 0;

            while (count < n - 1 && !pq.isEmpty()) {
                int[] edge = pq.poll();

                int a = find(edge[0]);
                int b = find(edge[1]);

                if (a == b) continue;

                count++;

                sum -= edge[2];

                root[Math.max(a, b)] = Math.min(a, b);
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }
}