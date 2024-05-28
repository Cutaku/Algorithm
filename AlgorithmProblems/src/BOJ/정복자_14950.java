package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 정복자_14950 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 0; i < n; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())});
        }

        int ans = (n - 2) * (n - 1) * t / 2;

        int c = 1;

        while (c < n) {
            int[] road = pq.poll();

            int a = find(road[0]);
            int b= find((road[1]));

            if (a == b) continue;

            ans += road[2];

            root[Math.max(a, b)] = Math.min(a, b);
            c++;
        }

        System.out.println(ans);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}