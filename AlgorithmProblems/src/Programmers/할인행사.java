package Programmers;

import java.util.*;

class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }

        int count = 0;

        for (int i = 0; i < discount.length; i++) {
            if (map.containsKey(discount[i])) {
                number[map.get(discount[i])]--;
            }

            if (i > 9 && map.containsKey(discount[i - 10])) {
                number[map.get(discount[i - 10])]++;
            }

            if (i > 8 && isSatisfied(number)) count++;
        }

        return count;
    }

    boolean isSatisfied(int[] number) {

        for (int num : number) {
            if (num > 0) return false;
        }

        return true;
    }
}