package Programmers;

import java.util.*;

class 숫자문자열과영단어 {
    public int solution(String s) {

        Map<String, String> map =  new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        for (String str : map.keySet()) {
            s = s.replaceAll(str, map.get(str));
        }

        return Integer.valueOf(s);


    }
}