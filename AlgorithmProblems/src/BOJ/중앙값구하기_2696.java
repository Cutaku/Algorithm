package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중앙값구하기_2696 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(n / 2 + 1).append("\n");
            st = new StringTokenizer(br.readLine());

            Median median = new Median(Integer.parseInt(st.nextToken()));
            sb.append(median.getMedian()).append(" ");

            for (int i = 0; i < n / 2; i++) {
                median.add(Integer.parseInt(st.nextToken()));

                if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                median.add(Integer.parseInt(st.nextToken()));

                if (i % 10 == 9) sb.append("\n");
                sb.append(median.getMedian()).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static class Median {

        int m;
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        public Median(int m) {
            this.m = m;
        }

        public void add(int x) {
            if (m >= x) lower.add(x);
            else higher.add(x);
        }

        public int getMedian() {

            if (lower.size() == higher.size()) return m;
            else if (lower.size() > higher.size()) {
                higher.add(m);
                return m = lower.poll();
            } else {
                lower.add(m);
                return m = higher.poll();
            }
        }
    }
}