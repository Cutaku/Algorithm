package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수열과쿼리22_16978 {
    static long[] seg;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        seg = new long[n << 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        init(1, 0, n - 1, st);

        int m = Integer.parseInt(br.readLine());

        Queue<int[]> query1 = new ArrayDeque<>();
        PriorityQueue<int[]> query2 = new PriorityQueue<>(Comparator.comparingInt(q -> q[1]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());

            if (q == 1) query1.add(new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())});
            else query2.add(new int[]{i, Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1});
        }

        List<Ans> ans = new ArrayList<>();

        int count = 0;

        while (!query1.isEmpty() || !query2.isEmpty()) {
            while (!query2.isEmpty() && count == query2.peek()[1]) {
                int[] q = query2.poll();

                ans.add(new Ans(sum(1, 0, n - 1, q[2], q[3]), q[0]));
            }

            if (!query1.isEmpty()) {
                int[] q = query1.poll();

                modify(1, 0, n - 1, q[0], q[1]);

                count++;
            }
        }

        ans.sort(Comparator.comparingInt(a -> a.index));

        for (Ans a : ans) {
            sb.append(a.value).append("\n");
        }

        System.out.println(sb);
    }

    static long modify(int idx, int left, int right, int target, int value) {

        if (right < target || target < left) return 0;

        if (left == right) {
            long temp = seg[idx];
            seg[idx] = value;
            return value - temp;
        }

        int mid = (left + right) >> 1;

        long c = modify(idx << 1, left, mid, target, value) + modify(idx << 1 | 1, mid + 1, right, target, value);

        seg[idx] += c;

        return c;
    }

    static long sum(int idx, int left, int right, int i, int j) {

        if (right < i || j < left) return 0;

        if (i <= left && right <= j) return seg[idx];

        int mid = (left + right) >> 1;

        return sum(idx << 1, left, mid, i, j) + sum(idx << 1 | 1, mid + 1, right, i, j);
    }

    static long init(int idx, int left, int right, StringTokenizer st) {

        if (left == right) return seg[idx] = Long.parseLong(st.nextToken());

        int mid = (left + right) >> 1;

        return seg[idx] = init(idx << 1, left, mid, st) + init(idx << 1 | 1 , mid + 1, right, st);
    }

    static class Ans {
        long value;
        int index;

        public Ans(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}