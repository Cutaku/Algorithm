package Programmers;

import java.util.*;

class 숫자변환하기 {
    public int solution(int x, int y, int n) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(x);

        int max = 1000000;

        boolean[] checked = new boolean[max + 1];
        checked[x] = true;

        int count = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == y) {
                return count;
            }

            if (now + n <= max && !checked[now + n]) {
                q2.add(now + n);
                checked[now + n] = true;
            }

            if (2 * now <= max && !checked[2 * now]) {
                q2.add(2 * now);
                checked[2 * now] = true;
            }

            if (3 * now <= max && !checked[3 * now]) {
                q2.add(3 * now);
                checked[3 * now] = true;
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        return -1;
    }
}