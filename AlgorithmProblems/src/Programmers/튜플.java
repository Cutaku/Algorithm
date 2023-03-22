package Programmers;

import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        s = s.replace("{", " ").replace("}", " ").replace(",", " ");

        int[] arr = Arrays.stream(s.strip().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int n = map.size();

        int[] result = new int[n];

        for (int num : map.keySet()) {
            result[n - map.get(num)] = num;
        }

        return result;
    }

}