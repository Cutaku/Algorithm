package Programmers;

import java.util.*;

class 택배상자 {
    public int solution(int[] order) {

        Stack<Integer> container = new Stack<>();

        int num = 1;

        int count = 0;

        for (int o : order) {
            if (!container.isEmpty() && container.peek() == o) {
                container.pop();
                count++;
                continue;
            }

            while (num < o) {
                container.add(num++);
            }

            if (num == o) {
                count++;
                num++;
            } else {
                break;
            }
        }

        return count;
    }
}