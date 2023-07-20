package Programmers;

import java.util.*;

class 연속부분수열합의개수 {
    public int solution(int[] elements) {

        int n = elements.length;

        int[] arr = new int[2 * n - 1];

        for (int i = 0; i < n; i++) arr[i] = elements[i];
        for (int i = n; i < 2 * n - 1; i++) arr[i] = elements[i - n];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += arr[i + j];

                set.add(sum);
            }
        }

        return set.size();
    }
}