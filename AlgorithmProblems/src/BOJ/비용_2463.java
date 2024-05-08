package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 비용_2463 {
    static int[] root;
    static int[] size;
    static int d = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        long cost = 0;

        root = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }

        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int[] edge = new int[3];

            edge[0] = Integer.parseInt(st.nextToken()) - 1;
            edge[1] = Integer.parseInt(st.nextToken()) - 1;
            edge[2] = Integer.parseInt(st.nextToken());

            edges.add(edge);

            cost += edge[2];
        }

        int ans = 0;

        while (!edges.isEmpty()) {
            int[] edge = edges.poll();

            int a = find(edge[0]);
            int b = find(edge[1]);
            int w = edge[2];

            if (a != b) {
                ans = (int) ((cost * size[a] * size[b] + ans) % d);

                if (a > b) {
                    int t = a;
                    a = b;
                    b = t;
                }

                root[b] = a;
                size[a] += size[b];
            }

            cost -= w;
        }

        System.out.println(ans);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}