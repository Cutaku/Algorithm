package Programmers;

import java.util.*;

class 인사고과 {
    public int solution(int[][] scores) {

        int n = scores.length;

        int wan1 = scores[0][0];
        int wan2 = scores[0][1];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        int num = scores[n - 1][0];
        int m1 = 0;
        int m2 = scores[n - 1][1];

        for (int i = n - 1; i >= 0; i--) {
            int[] score = scores[i];

            if (score[0] > wan1 && score[1] > wan2) return -1;

            if (score[0] < num) {
                m1 = Math.max(m1, m2);
                m2 = score[1];
                num = score[0];
            }

            if (score[1] < m1) {
                score[0] = 0;
                score[1] = 0;
            }
        }

        int count = 1;

        for (int[] score : scores) {
            if (wan1 + wan2 < score[0] + score[1]) count++;
        }

        return count;
    }
}