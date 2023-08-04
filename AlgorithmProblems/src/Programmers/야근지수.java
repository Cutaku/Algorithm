package Programmers;

import java.util.*;

class 야근지수 {
    public long solution(int n, int[] works) {

        long ans = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int work : works) {
            pq.add((long) work * -1);
        }

        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) break;

            long m = pq.poll();
            m++;

            if (m < 0) pq.add(m);
        }

        for (long m : pq) {
            ans += m * m;
        }

        return ans;
    }
}