package Programmers;

import java.util.*;

class 소수찾기 {
    static Set<Integer> set;
    static int[] nums;
    static boolean[] used;

    public int solution(String numbers) {

        set = new HashSet<>();
        nums = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        int n = nums.length;

        used = new boolean[n];

        dfs("");


        return set.size();
    }

    public void dfs(String str) {

        if (!str.isEmpty()) {
            int p = Integer.parseInt(str);
            if (isPrime(p)) {
                set.add(p);
            }
        }

        int n = used.length;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(str + nums[i]);
                used[i] = false;
            }
        }
    }

    public boolean isPrime(int p) {

        if (p < 2) return false;
        if (p == 2) return true;
        if (p % 2 == 0) return false;

        for (int i = 3; i * i < p + 1; i += 2) {
            if (p % i == 0) return false;
        }

        return true;
    }
}