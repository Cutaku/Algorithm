package Programmers;

import java.util.*;

class 성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String surv = survey[i];
            int choice = choices[i];

            if (choice < 4) {
                char c = surv.charAt(0);
                map.put(c, map.get(c)  + 4 - choice);
            } else {
                char c = surv.charAt(1);
                map.put(c, map.get(c) + choice - 4);
            }
        }

        String ans = "";
        if (map.get('R') >= map.get('T')) ans += "R";
        else ans += "T";
        if (map.get('C') >= map.get('F')) ans += "C";
        else ans += "F";
        if (map.get('J') >= map.get('M')) ans += "J";
        else ans += "M";
        if (map.get('A') >= map.get('N')) ans += "A";
        else ans += "N";

        return ans;
    }
}