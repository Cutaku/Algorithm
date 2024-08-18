package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 합_1132 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] count = new long[10];
        boolean[] nonZero = new boolean[10];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int l = word.length();
            long d = 1;

            for (int j = l - 1; j >= 0; j--) {
                count[word.charAt(j) - 'A'] += d;
                d *= 10;
            }

            nonZero[word.charAt(0) - 'A'] = true;
        }

        PriorityQueue<Char> pq = new PriorityQueue<>(Comparator.comparingLong(c -> c.count));

        for (int i = 0; i < 10; i++) {
            pq.add(new Char(i, count[i]));
        }

        List<Char> tmp = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Char poll = pq.poll();

            if (!nonZero[poll.idx]) {
                pq.addAll(tmp);
                break;
            }

            tmp.add(poll);
        }

        long ans = 0;

        for (int i = 1; i < 10; i++) {
            ans += pq.poll().count * i;
        }

        System.out.println(ans);
    }

    static class Char {
        int idx;
        long count;

        public Char(int idx, long count) {
            this.idx = idx;
            this.count = count;
        }
    }
}