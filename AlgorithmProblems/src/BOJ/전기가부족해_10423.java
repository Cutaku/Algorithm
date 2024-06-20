package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전기가부족해_10423 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        root = new int[n];
        for (int i = 1; i < n; i++) root[i] = i;

        int[] plants = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) plants[i] = Integer.parseInt(st.nextToken()) - 1;

        Arrays.sort(plants);
        for (int i = 1; i < k; i++) root[plants[i]] = plants[0];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int[] cable = new int[3];

            cable[0] = Integer.parseInt(st.nextToken()) - 1;
            cable[1] = Integer.parseInt(st.nextToken()) - 1;
            cable[2] = Integer.parseInt(st.nextToken());

            pq.add(cable);
        }

        int count = k;
        int cost = 0;

        while (!pq.isEmpty() && count < n) {
            int[] now = pq.poll();

            int a = find(now[0]);
            int b = find(now[1]);

            if (a == b) continue;

            count++;
            cost += now[2];

            root[Math.max(a, b)] = Math.min(a, b);
        }

        System.out.println(cost);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}