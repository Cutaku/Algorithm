package Programmers;

import java.util.*;

class 풍선터뜨리기 {
    public int solution(int[] a) {

        Stack<Integer> stack = new Stack<>();

        int l = a.length;

        int minus = 0;

        for (int i = 0; i < l; i++) {
            while (!stack.isEmpty() && stack.peek() > a[i]) {
                if (stack.size() > 1) minus++;

                stack.pop();
            }

            stack.push(a[i]);
        }

        return l - minus;
    }
}