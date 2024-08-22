package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 꼬인전깃줄_1365 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];
        Arrays.fill(tree, Integer.MIN_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            pq.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] poll = pq.poll();

            int max = findMax(poll[0]);
            modify(poll[0], max + 1);

            ans = Math.max(ans, max + 1);
        }

        System.out.println(n - ans);
    }

    static void modify(int i, int max) {

        while (i <= n) {
            tree[i] = Math.max(tree[i], max);
            i += i & -i;
        }
    }

    static int findMax(int i) {

        int max = 0;

        while (i > 0) {
            max = Math.max(max, tree[i]);
            i -= i & -i;
        }

        return max;
    }
}