package Programmers;

import java.util.*;

class N으로표현 {
    public int solution(int N, int number) {


        List<Integer>[] lists = new List[9];
        for (int i = 1; i < 9; i++) lists[i] = new ArrayList<>();

        int[] count = new int[100000000];
        Arrays.fill(count, -1);

        lists[1].add(N);
        count[N] = 1;

        int init = N;

        for (int i = 2; i < 9; i++) {
            init *= 10;
            init += N;

            lists[i].add(init);

            for (int j = 1; j < i; j++) {
                List<Integer> l1 = lists[j];
                List<Integer> l2 = lists[i - j];

                for (int n1 : l1) {
                    for (int n2 : l2) {
                        lists[i].add(n1 + n2);

                        lists[i].add(n1 * n2);

                        if (n1 >= n2) lists[i].add(n1 - n2);
                        else lists[i].add(n2 - n1);

                        if (n1 >= n2 && n2 > 0 && n1 % n2 == 0) lists[i].add(n1 / n2);
                        if (n2 > n1 && n1 > 0 && n2 % n1 == 0) lists[i].add(n2 / n1);
                    }
                }
            }

            for (int num : lists[i]) {
                if (count[num] == -1) count[num] = i;
            }
        }

        return count[number];
    }
}