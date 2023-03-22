package Programmers;

import java.util.*;

class 행렬과연산 {
    public int[][] solution(int[][] rc, String[] operations) {

        Matrix matrix = new Matrix(rc);

        for (String op : operations) {
            if (op.equals("Rotate")) matrix.rotate();
            else matrix.shift();
        }

        return matrix.toIntArray();
    }

    class Matrix {
        int n = 0;
        int m = 0;

        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> right = new LinkedList<>();
        Deque<Deque<Integer>> center = new LinkedList<>();

        Matrix(int[][] rc) {
            n = rc.length;
            m = rc[0].length;
            for (int[] r : rc) {
                left.add(r[0]);

                Deque<Integer> deq = new LinkedList<>();
                for (int i = 1; i < m-1; i++) {
                    deq.add(r[i]);
                }
                center.add(deq);

                right.add(r[m-1]);
            }
        }

        void shift() {
            left.addFirst(left.removeLast());
            right.addFirst(right.removeLast());
            center.addFirst(center.removeLast());
        }

        void rotate() {

            if (m == 2) {
                left.add(right.removeLast());
                right.addFirst(left.removeFirst());
            } else {
                left.add(center.getLast().removeFirst());
                center.getLast().add(right.removeLast());
                right.addFirst(center.getFirst().removeLast());
                center.getFirst().addFirst(left.removeFirst());
            }
        }

        int[][] toIntArray() {
            int[][] result = new int[n][];

            for (int i = 0; i < n; i++) {
                int[] temp = new int[m];

                temp[0] = left.removeFirst();

                Deque<Integer> deq = center.removeFirst();

                for (int j = 1; j < m-1; j++) {
                    temp[j] = deq.removeFirst();
                }

                temp[m-1] = right.removeFirst();

                result[i] = temp;
            }

            return result;
        }
    }
}