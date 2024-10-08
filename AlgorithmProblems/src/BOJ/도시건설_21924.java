package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시건설_21924 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        long ans = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});

            ans += c;
        }


        int cnt = 1;

        while (cnt < n && !pq.isEmpty()) {
            int[] poll = pq.poll();

            int a = find(poll[0]), b = find(poll[1]);

            if (a == b) continue;

            cnt++;

            ans -= poll[2];

            root[Math.min(a, b)] = Math.max(a, b);
        }

        System.out.println(cnt == n ? ans : -1);
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}