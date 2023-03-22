package Programmers;

import java.util.*;

class 불량사용자 {
    public int solution(String[] user_id, String[] banned_id) {

        if (banned_id.length == user_id.length) return 1;

        Set<Integer> visited = new HashSet<>();

        int[] arr = new int[banned_id.length];
        Arrays.fill(arr, -1);

        dfs(user_id, banned_id, arr, visited);

        return visited.size();
    }

    void dfs(String[] user_id, String[] banned_id, int[] arr, Set<Integer> visited) {

        int count = 0;
        for (int num : arr) if (num > -1) count++;
        if (count == banned_id.length) {

            visited.add(toInt(arr));

            return;
        }

        for (int i = 0; i < user_id.length; i++) {

            boolean flag = false;

            for (int j = 0; j < banned_id.length; j++) {
                if (arr[j] == i) flag = true;
            }

            if (flag) continue;

            for (int j = 0; j < banned_id.length; j++) {

                if (arr[j] > -1) continue;

                if (match(user_id[i], banned_id[j])) {
                    arr[j] = i;
                    dfs(user_id, banned_id, arr, visited);
                    arr[j] = -1;
                }
            }
        }
    }

    boolean match (String user, String banned) {

        if (user.length() != banned.length()) return false;

        int l = user.length();

        for (int i = 0; i < l; i++) {
            char c1 = user.charAt(i);
            char c2 = banned.charAt(i);

            if (c1 != c2 && c2 != '*') return false;
        }

        return true;
    }

    int toInt(int[] arr) {

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -1) result += Math.pow(2, arr[i]);
        }

        return result;
    }
}