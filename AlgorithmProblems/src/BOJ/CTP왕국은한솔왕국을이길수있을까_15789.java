package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CTP왕국은한솔왕국을이길수있을까_15789 {
    static int[] root;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        root = new int[n];
        count = new int[n];

        for (int i = 0; i < n; i++) root[i] = i;
        Arrays.fill(count, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = find(Integer.parseInt(st.nextToken()) - 1);
            int b = find(Integer.parseInt(st.nextToken()) - 1);

            if (a == b) continue;

            root[Math.max(a, b)] = Math.min(a, b);
            count[Math.min(a, b)] += count[Math.max(a, b)];
        }

        st = new StringTokenizer(br.readLine());
        int c = find(Integer.parseInt(st.nextToken()) - 1);
        int h = find(Integer.parseInt(st.nextToken()) - 1);
        int k = Integer.parseInt(st.nextToken());

        int ans = count[c];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int j = find(i);

            if (i == j && i != c && i != h) {
                pq.add(count[i]);
            }
        }

        while (!pq.isEmpty() && k-- > 0) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}