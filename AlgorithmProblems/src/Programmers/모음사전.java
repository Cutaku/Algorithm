package Programmers;

import java.util.*;

class 모음사전 {
    static int count;
    static Map<String, Integer> map;

    public int solution(String word) {

        count = 0;
        map = new HashMap<>();

        dfs("");

        return map.get(word);
    }

    void dfs(String str) {

        map.put(str, count++);

        if (str.length() == 5) return;

        char[] chars = new char[] { 'A', 'E', 'I', 'O', 'U'};
        for (char c : chars) dfs(str + c);
    }
}