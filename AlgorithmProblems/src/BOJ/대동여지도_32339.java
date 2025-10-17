package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 대동여지도_32339 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] priority = new int[3];

        for (int i = 0; i < 3; i++) {
            priority[Integer.parseInt(st.nextToken())] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) return priority[a[3]] - priority[b[3]];
            return a[2] - b[2];
        });

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            pq.add(new int[]{u, v, w, k});
        }

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[][] ans = new int[3][2];

        while (ans[0][0] + ans[1][0] + ans[2][0] < n - 1) {
            int[] road = pq.poll();

            int a = find(road[0]);
            int b = find(road[1]);

            if (a == b) continue;

            int c = Math.min(a, b);
            root[a + b - c] = c;

            ans[road[3]][0]++;
            ans[road[3]][1] += road[2];
        }

        System.out.println(ans[0][1] + ans[1][1] + ans[2][1]);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}