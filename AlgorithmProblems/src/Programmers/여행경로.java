package Programmers;

import java.util.*;

class 여행경로 {
    static int n;
    static boolean fin;
    static boolean[] used;
    static String[][] T;
    static String now;
    static String[] result;

    public String[] solution(String[][] tickets) {

        n = tickets.length;
        fin = false;
        used = new boolean[n];

        Arrays.sort(tickets, Comparator.comparing((String[] t) -> t[1]));
        T = tickets;

        now  = "ICN";
        result = new String[n + 1];
        result[0] = now;

        dfs(1);

        return result;
    }

    public void dfs(int d) {

        if (d == n + 1) {
            fin = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            String[] ticket = T[i];

            if (!ticket[0].equals(now)) continue;

            used[i] = true;
            now = ticket[1];
            result[d] = ticket[1];

            dfs(d + 1);

            used[i] = false;
            now = ticket[0];

            if (fin) return;
        }
    }
}