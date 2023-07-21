package Programmers;

import java.util.*;

class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {

        List<Integer> list = new ArrayList<>();

        list.add(k);

        while (k > 1) {
            if (k % 2 == 1) k = 3 * k + 1;
            else k /= 2;

            list.add(k);
        }

        int l = list.size();

        double[] integral = new double[l];

        for (int i = 1; i < l; i++) {
            double d = list.get(i - 1) + list.get(i);
            integral[i] = integral[i - 1] + d / 2;
        }

        int r = ranges.length;

        double[] ans = new double[r];

        for (int i = 0; i < r; i++) {
            int s = ranges[i][0];
            int e = l - 1 + ranges[i][1];

            if (e < s) ans[i] = -1;
            else ans[i] = integral[e] - integral[s];
        }

        return ans;
    }
}