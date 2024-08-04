package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 버블소트_1517 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            pq.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            ans += sum(poll[0] - 1);
            modify(poll[0]);
        }

        System.out.println(ans);
    }

    static void modify(int i) {

        while (i <= n) {
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