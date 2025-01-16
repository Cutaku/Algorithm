package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 안정적인네트워크_2406 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int component = n - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = find(Integer.parseInt(st.nextToken()) - 1), b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a == b) continue;

            component--;
            root[Math.max(a, b)] = Math.min(a, b);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            for (int j = 1; j < i; j++) {
                pq.add(new int[]{i, j, Integer.parseInt(st.nextToken())});
            }
        }

        int cost = 0;
        int cnt = 1;

        while (cnt < component) {
            int[] poll = pq.poll();
            int a = find(poll[0]), b = find(poll[1]);

            if (a == b) continue;

            sb.append(poll[0] + 1).append(" ").append(poll[1] + 1).append("\n");

            cnt++;
            cost += poll[2];

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(cost + " " + (component - 1));
        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}