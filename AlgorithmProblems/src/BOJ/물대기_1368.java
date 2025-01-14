package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 물대기_1368 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 1; i <= n; i++) pq.add(new int[]{0, i, Integer.parseInt(br.readLine())});

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < i; j++) {
                pq.add(new int[]{i, j, Integer.parseInt(st.nextToken())});
            }
        }

        root = new int[n + 1];
        for (int i = 1; i <= n; i++) root[i] = i;

        int component = n + 1;
        int sum = 0;

        while (component > 1) {
            int[] poll = pq.poll();
            int a = find(poll[0]), b = find(poll[1]);

            if (a == b) continue;

            component--;
            sum += poll[2];

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(sum);
    }

    static int find(int a) {

        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}