package Programmers;

import java.util.*;

class 수식최대화 {
    public long solution(String expression) {

        long ans = 0L;

        ans = Math.max(ans, Math.abs(calculate(expression, '+', '-', '*')));
        ans = Math.max(ans, Math.abs(calculate(expression, '+', '*', '-')));
        ans = Math.max(ans, Math.abs(calculate(expression, '-', '+', '*')));
        ans = Math.max(ans, Math.abs(calculate(expression, '-', '*', '+')));
        ans = Math.max(ans, Math.abs(calculate(expression, '*', '+', '-')));
        ans = Math.max(ans, Math.abs(calculate(expression, '*', '-', '+')));

        return ans;
    }

    public long calculate(String expression, char o1, char o2, char o3) {

        Queue<Long> nums = new LinkedList<>();
        Queue<Character> orders = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                nums.add(Long.parseLong(sb.toString()));
                orders.add(c);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        nums.add(Long.parseLong(sb.toString()));

        rotate(nums, orders, o1);
        rotate(nums, orders, o2);
        rotate(nums, orders, o3);

        return nums.poll();
    }

    public void rotate(Queue<Long> nums, Queue<Character> orders, char o) {

        long n = nums.poll();

        long l = orders.size();

        for (int i = 0; i < l; i++) {
            long num = nums.poll();
            char order = orders.poll();

            if (order == o) {
                n = order(n, num, o);
            } else {
                nums.add(n);
                n = num;
                orders.add(order);
            }
        }

        nums.add(n);
    }

    public long order(long a, long b, char c) {

        if (c == '+') return a + b;
        else if (c == '-') return a - b;
        else return a * b;
    }
}