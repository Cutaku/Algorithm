package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로_1251 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            int n = Integer.parseInt(br.readLine());

            long[][] points = new long[n][2];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    points[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e[2]));

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    pq.add(new long[]{i, j,
                            (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1])});
                }
            }

            int[] root = new int[n + 1];
            for (int i = 0; i <= n; i++) root[i] = i;

            double sum = 0;
            double e = Double.parseDouble(br.readLine());

            int count = 0;

            while (count < n - 1) {
                long[] edge = pq.poll();

                int a = find((int)edge[0], root);
                int b = find((int)edge[1], root);

                if (a == b) continue;

                count++;

                root[Math.max(a, b)] = Math.min(a, b);

                sum += edge[2] * e;
            }

            sb.append(String.format("%.0f\n", sum));
        }

        System.out.println(sb);
    }

    static int find(int x, int[] root) {

        if (x == root[x]) return x;
        return root[x] = find(root[x], root);
    }
}