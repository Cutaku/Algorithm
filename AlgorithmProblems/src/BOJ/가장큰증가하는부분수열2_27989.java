package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열2_27989 {
    static int n;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new long[n + 1];

        PriorityQueue<Num> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            pq.add(new Num(i, Long.parseLong(st.nextToken())));
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            Num num = pq.poll();

            long max = find(num.idx - 1);
            modify(num.idx, max + num.num);

            ans = Math.max(ans, max + num.num);
        }

        System.out.println(ans);
    }

    static void modify(int i, long num) {

        while (i <= n) {
            tree[i] = Math.max(tree[i], num);
            i += i & -i;
        }
    }

    static long find(int i) {

        long res = 0;

        while (i > 0) {
            res = Math.max(res, tree[i]);
            i -= i & -i;
        }

        return res;
    }

    static class Num implements Comparable<Num> {
        int idx;
        long num;

        public Num(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            if (this.num == o.num) return o.idx - this.idx;
            return Long.compare(this.num, o.num);
        }
    }
}