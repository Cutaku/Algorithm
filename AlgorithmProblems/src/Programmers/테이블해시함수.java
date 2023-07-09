package Programmers;

import java.util.*;

class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (d1, d2) -> {
            if (d1[col - 1] == d2[col - 1]) return d2[0] - d1[0];
            else return d1[col - 1] - d2[col - 1];
        });

        int ans = 0;

        for (int i = row_begin - 1; i < row_end; i++) {
            int s = 0;

            for (int d : data[i]) {
                s += d % (i + 1);
            }

            ans ^= s;
        }

        return ans;
    }
}