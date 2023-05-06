package Programmers;

import java.util.*;

class 숫자게임 {
    public int solution(int[] A, int[] B) {

        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int id_a = n - 1;
        int id_b = n - 1;

        int count = 0;

        while (id_a >= 0) {
            if (A[id_a] < B[id_b]) {
                count++;
                id_a--;
                id_b--;
            } else {
                id_a--;
            }
        }

        return count;
    }
}