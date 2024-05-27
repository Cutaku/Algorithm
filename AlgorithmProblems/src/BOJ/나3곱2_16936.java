package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나3곱2_16936 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Compare> pq = new PriorityQueue<>((c1, c2) -> {
            if (c1.c == c2.c) {
                return Long.compare(c1.n, c2.n);
            } else {
                return c2.c - c1.c;
            }
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(new Compare(Long.parseLong(st.nextToken())));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll().n).append(" ");
        }

        System.out.println(sb);
    }

    static class Compare {
        long n;
        int c;

        public Compare(long n) {
            this.n = n;

            long m = n;
            while (m % 3 == 0) {
                m /= 3;
                c++;
            }
        }
    }
}