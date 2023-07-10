package Programmers;

import java.util.*;

class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {

        Stack<Integer> nums = new Stack<>();
        Stack<Integer> inds = new Stack<>();

        int[] ans = new int[numbers.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < numbers.length; i++) {
            while (!nums.isEmpty() && nums.peek() < numbers[i]) {
                ans[inds.pop()] = numbers[i];
                nums.pop();
            }

            inds.add(i);
            nums.add(numbers[i]);
        }

        return ans;
    }
}