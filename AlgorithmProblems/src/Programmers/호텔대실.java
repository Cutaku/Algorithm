package Programmers;

import java.util.*;

class 호텔대실 {
    public int solution(String[][] book_time) {

        Arrays.sort(book_time, (t1, t2) -> {
            if (t1[0].equals(t2[0])) return toInt(t1[1]) - toInt(t2[1]);
            else return toInt(t1[0]) - toInt(t2[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;

        for (String[] time : book_time) {
            int start = toInt(time[0]);
            int end = toInt(time[1]) + 10;

            if (!pq.isEmpty() && pq.peek() <= start) pq.poll();

            pq.add(end);

            ans = Math.max(ans, pq.size());
        }

        return ans;
    }

    public int toInt(String time) {

        int[] hm = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();

        return hm[0] * 60 + hm[1];
    }
}