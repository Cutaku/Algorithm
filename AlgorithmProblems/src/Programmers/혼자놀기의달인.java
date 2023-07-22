package Programmers;

import java.util.*;

class 혼자놀기의달인 {
    public int solution(int[] cards) {

        PriorityQueue<Integer> groups = new PriorityQueue<>();

        int n = cards.length;

        boolean[] checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (checked[i]) continue;

            int count = 0;

            while (!checked[i]) {
                count++;
                checked[i] = true;

                i = cards[i] - 1;
            }

            groups.add(count * -1);
        }

        if (groups.size() <= 1) return 0;
        else return groups.poll() * groups.poll();
    }
}