package Programmers;

import java.util.*;

class 시소짝꿍 {
    public long solution(int[] weights) {

        long[] count = new long[3000];
        Set<Integer> set = new HashSet<>();

        for (int weight : weights) {
            count[weight]++;
            set.add(weight);
        }

        long ans = 0;

        for (int weight : set) {
            ans += count[weight] * (count[weight] - 1) / 2;
            ans += count[weight] * count[2 * weight];
            if (weight % 2 == 0) ans += count[weight] * count[weight * 3 / 2];
            if (weight % 3 == 0) ans += count[weight] * count[weight * 4 / 3];
        }

        return ans;
    }
}