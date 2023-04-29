package Programmers;

import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {

        int turn = 0;

        Set<String> set = new HashSet<>();

        String last = null;

        boolean fin = true;

        for (String word : words) {
            if (set.add(word)) {
                if (last != null && last.charAt(last.length() - 1) != word.charAt(0)) {
                    fin = false;
                    break;
                }

                turn++;
                last = word;
            } else {
                fin = false;
                break;
            }
        }

        int[] answer = new int[2];

        answer[0] = turn % n + 1;
        answer[1] = turn / n + 1;

        if (fin) return new int[]{0, 0};
        else return answer;
    }
}