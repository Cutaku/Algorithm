package Programmers;

import java.util.*;

class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {

        int n = board.length;
        Queue<Integer>[] q = new Queue[n];
        for (int i = 0; i < n; i++) {
            q[i] = new LinkedList<>();
        }

        for (int[] line : board) {
            for (int i = 0; i < n; i++) {
                if (line[i] > 0) q[i].add(line[i]);
            }
        }

        Stack<Integer> s = new Stack<>();
        int count = 0;

        for (int move : moves) {

            if (q[move - 1].isEmpty()) continue;

            int input = q[move - 1].poll();

            if (s.isEmpty()) {
                s.add(input);
            } else {
                int output = s.pop();

                if (input == output) count += 2;
                else {
                    s.add(output);
                    s.add(input);
                }
            }
        }


        return count;

    }
}