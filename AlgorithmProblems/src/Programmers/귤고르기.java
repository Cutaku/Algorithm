package Programmers;

import java.util.*;

class 귤고르기 {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            if (map.containsKey(t)){
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int key : map.keySet()) {
            pq.add(map.get(key) * -1);
        }

        int count = 0;
        int ans = 0;

        while (count < k) {
            count -= pq.poll();
            ans++;
        }

        return ans;
    }
}