package Programmers;

import java.util.*;

class 광물캐기 {
    static int min;
    static int count;
    static int[] P;
    static String[] M;
    static Map<String, Integer>[] map;

    public int solution(int[] picks, String[] minerals) {
        min = 1250;
        count = 0;
        P = picks;
        M = minerals;
        map = new Map[3];

        for (int i = 0; i < 3; i++) map[i] = new HashMap<>();

        map[0].put("diamond", 1);
        map[0].put("iron", 1);
        map[0].put("stone", 1);
        map[1].put("diamond", 5);
        map[1].put("iron", 1);
        map[1].put("stone", 1);
        map[2].put("diamond", 25);
        map[2].put("iron", 5);
        map[2].put("stone", 1);

        dfs(0);

        return min;
    }

    public void dfs(int d) {
        if (P[0] == 0 && P[1] == 0 && P[2] == 0) {
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (P[i] == 0) continue;

            int temp = count;

            P[i]--;

            for (int j = 0; j < 5; j++) {
                if (d + j >= M.length) {
                    min = Math.min(min, count);
                    continue;
                }

                count += map[i].get(M[d + j]);
            }

            dfs(d + 5);

            P[i]++;

            count = temp;
        }
    }
}