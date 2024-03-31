package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 좋은수_1060 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int l = Integer.parseInt(br.readLine());
        
        long[] arr = new long[l + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= l; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        PriorityQueue<Range> pq = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) return Long.compare(a.num, b.num);
            else return Long.compare(a.value, b.value);
        });

        for (int i = 1; i <= l; i++) {
            pq.add(new Range(arr[i] - 1, arr[i] + 1));
            if (arr[i] - arr[i - 1] > 1) pq.add(new Range(arr[i - 1], arr[i]));
        }

        int n = Integer.parseInt(br.readLine());

        int c = 0;

        while (!pq.isEmpty() && c < n) {
            Range r = pq.poll();

            sb.append(r.num).append(" ");

            if (r.update()) pq.add(r);

            c++;
        }

        for (int i = c + 1; i <= n; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static class Range {
        long left, right, mid;
        long value;
        long num;
        int i = 1;

        public Range(long left, long right) {
            this.left = left;
            this.right = right;
            this.mid = (left + right + 1) >> 1;
            this.value = right - left - 2;
            this.num = left + i;
        }

        boolean update() {
            if (num == mid) return false;

            if (num < mid) {
                num = right - i;
            } else {
                num = left + ++i;
                value = i * (right - left - i) - 1;
            }

            return true;
        }
    }
}