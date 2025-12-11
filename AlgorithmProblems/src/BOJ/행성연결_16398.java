package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성연결_16398 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i; j++) {
                pq.add(new int[]{i, j, Integer.parseInt(st.nextToken())});
            }
        }

        long ans = 0;
        int component = n;

        while (component > 1) {
            int[] poll = pq.poll();

            int a = find(poll[0]);
            int b = find(poll[1]);

            if (a == b) continue;

            component--;
            ans += poll[2];

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(ans);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}