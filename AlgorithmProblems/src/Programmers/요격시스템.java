package Programmers;

import java.util.*;

class 요격시스템 {
    public int solution(int[][] targets) {

        Arrays.sort(targets, (a1, a2) -> {
            if (a1[0] == a2[0]) return a1[1] - a2[1];
            else return a1[0] - a2[0];
        });
        int e = targets[0][1];

        int count = 1;

        for (int i = 1; i < targets.length; i++) {
            int[] target = targets[i];

            if (e <= target[0]) {
                e = target[1];
                count++;
            } else if (target[1] < e) {
                e = target[1];
            }
        }

        return count;
    }
}