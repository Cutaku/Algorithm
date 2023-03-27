package Programmers;

import java.util.*;

class 모의고사 {
    public int[] solution(int[] answers) {

        int c1 = 0, c2 = 0, c3 = 0;

        int[] a1 = new int[] {1, 2, 3, 4, 5};
        int[] a2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            if (answer == a1[i % 5]) c1++;
            if (answer == a2[i % 8]) c2++;
            if (answer == a3[i % 10]) c3++;
        }

        int max = Math.max(c1, Math.max(c2, c3));

        List<Integer> list = new ArrayList<>();

        if (c1 == max) list.add(1);
        if (c2 == max) list.add(2);
        if (c3 == max) list.add(3);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}