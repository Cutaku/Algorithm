package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 군사이동_11085 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));

        root = new int[p];
        for (int i = 1; i < p; i++) root[i] = i;

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int min = 0;

        while (find(c) != find(v)) {
            int[] poll = pq.poll();

            int x = find(poll[0]), y = find(poll[1]);

            if (x != y) {
                root[Math.max(x, y)] = Math.min(x, y);
                min = poll[2];
            }
        }

        System.out.println(min);
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}