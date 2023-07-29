package Programmers;

import java.util.*;

class 최고의집합 {
    public int[] solution(int n, int s) {

        if (n > s) return new int[]{-1};

        int[] ans = new int[n];

        int d = s / n;
        int r = s % n;

        Arrays.fill(ans, d);

        for (int i = 0; i < r; i++) {
            ans[n - 1 - i]++;
        }

        return ans;
    }
}