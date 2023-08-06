package Programmers;

import java.util.*;

class 거스름돈 {
    public int solution(int n, int[] money) {

        int l = money.length;

        Arrays.sort(money);

        int[][] count = new int[n + 1][l + 1];

        for (int i = 1; i <= l; i++) {
            count[0][i]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                count[i][j] += count[i][j - 1];
                if (money[j - 1] <= i) count[i][j] += count[i - money[j - 1]][j];
            }
        }

        return count[n][l];
    }
}