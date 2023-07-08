package Programmers;

import java.util.*;

class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;

        for (int e : enemy) {
            n -= e;
            pq.add(e * -1);

            while (n < 0 && k > 0) {
                n -= pq.poll();
                k--;
            }

            if (n >= 0) count++;
            else break;
        }

        return count;
    }
}