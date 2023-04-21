package Programmers;

import java.util.*;

class 방의개수 {
    public int solution(int[] arrows) {

        long n = 100001L;
        long m = n * n + 1;

        int[][] D = new int[][] {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        Set<Long> v = new HashSet<>();
        Set<Long> e = new HashSet<>();

        int x = 0;
        int y = 0;

        v.add(0L);

        int count = 0;

        int l = arrows.length;

        for (int i = 0; i < 2 * l; i++) {
            int[] d = D[arrows[i / 2]];

            int nx = x + d[0];
            int ny = y + d[1];

            long v1 = n * y + x;
            long v2 = n * ny + nx;
            long e1 = Math.max(v1, v2) * m + Math.min(v1, v2);

            if (v.contains(v2) && !e.contains(e1)) count++;

            v.add(v2);
            e.add(e1);

            x = nx;
            y = ny;
        }

        return count;
    }
}