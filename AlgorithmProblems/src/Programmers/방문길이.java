package Programmers;

import java.util.*;

class 방문길이 {
    public int solution(String dirs) {

        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('R', new int[]{1, 0});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});

        boolean[][] edges = new boolean[121][];
        for (int i = 0; i < 121; i++) edges[i] = new boolean[121];

        int l = dirs.length();

        int x = 5;
        int y = 5;

        int count = 0;

        for (int i = 0; i < l; i++) {
            char c = dirs.charAt(i);

            int[] d = map.get(c);

            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;

            int p1 = x + 11 * y;
            int p2 = nx + 11 * ny;

            if (!edges[p1][p2]) {
                edges[p1][p2] = true;
                edges[p2][p1] = true;
                count++;
            }

            x = nx;
            y = ny;
        }


        return count;
    }
}