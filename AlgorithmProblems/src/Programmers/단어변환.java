package Programmers;

import java.util.*;

class 단어변환 {
    public int solution(String begin, String target, String[] words) {

        int n = words.length;

        boolean[] used = new boolean[n];

        boolean pos = false;

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();

        int count = 0;

        q1.add(begin);

        while (!q1.isEmpty()) {

            String now = q1.poll();

            if (now.equals(target)) {
                pos = true;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (used[i] || !pos(now, words[i])) continue;

                used[i] = true;
                q2.add(words[i]);
            }

            if (q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                count++;
            }
        }

        if (pos) return count;
        else return 0;
    }

    public boolean pos(String str1, String str2) {

        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }

        return (count == 1);
    }
}