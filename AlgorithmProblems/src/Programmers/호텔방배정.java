package Programmers;

import java.util.*;

class 호텔방배정 {
    public long[] solution(long k, long[] arr) {

        int n = arr.length;

        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            long m = arr[i];

            if (!map.containsKey(m)) {
                map.put(m, m + 1);
            } else {

                List<Long> l = new ArrayList<>();

                while (map.containsKey(m)) {
                    l.add(m);
                    m = map.get(m);
                }

                map.put(m, m + 1);
                for (long num : l) map.put(num, m + 1);
                arr[i] = m;
            }
        }

        return arr;
    }
}