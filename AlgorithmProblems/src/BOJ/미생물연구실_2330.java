package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미생물연구실_2330 {
    static int n;
    static int[] tree;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[50002];
        v = new boolean[50002];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + 1;
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, c});
        }

        while (!pq.isEmpty()) {
            int[] micro = pq.poll();

            micro[2] -= sum(micro[1]) - sum(micro[0]);

            int idx = micro[1] + 1;

            while (micro[2] > 0) {
                if (v[--idx]) continue;

                add(idx);
                micro[2]--;
            }
        }

        System.out.println(sum(50001));
    }

    static void add(int i) {

        v[i] = true;

        while (i < 50002) {
            tree[i]++;
            i += i & -i;
        }
    }

    static int sum(int i) {

        int res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}