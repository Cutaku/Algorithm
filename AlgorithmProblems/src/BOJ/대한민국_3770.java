package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 대한민국_3770 {
    static int n, m, k;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int e, w, c;
        long ans;

        for (int t = 1; t <= T; t++) {
            sb.append("Test case ").append(t).append(": ");

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            tree = new long[m + 1];

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0], b[0]);
            });

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                e = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());

                pq.add(new int[]{e, w});
            }

            ans = 0;
            c = 0;

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                ans += c++ - find(now[1]);
                modify(now[1]);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static void modify(int i) {

        while (i <= m) {
            tree[i]++;
            i += i & -i;
        }
    }

    static long find(int i) {

        long res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}