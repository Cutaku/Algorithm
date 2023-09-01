package Programmers;

import java.util.*;

class 최소값만들기 {
    public int solution(int []A, int []B) {

        int l = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;

        for (int i = 0; i < l; i++) {
            ans += A[i] * B[l - 1 - i];
        }

        return ans;
    }
}