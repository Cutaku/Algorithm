package Programmers;

import java.util.*;

class 억억단을외우자 {
    public int[] solution(int e, int[] starts) {

        int[] count = new int[5000001];

        Arrays.fill(count, 1);

        for (int i = 2; i <= 5000000; i++) {
            for (int j = 1; j * i <= 5000000; j++) {
                count[i * j]++;
            }
        }

        int[][] max = new int[e + 1][];

        max[e] = new int[]{e, count[e]};

        for (int i = e - 1; i > 0; i--) {
            if (count[i] >= max[i + 1][1]) {
                max[i] = new int[]{i, count[i]};
            } else {
                max[i] = max[i + 1];
            }
        }

        int[] ans = new int[starts.length];

        for (int i = 0; i < starts.length; i++) {
            ans[i] = max[starts[i]][0];
        }

        return ans;
    }
}