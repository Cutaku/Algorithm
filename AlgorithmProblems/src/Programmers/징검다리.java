package Programmers;

import java.util.*;

class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        int s = 0;
        int e = 1000000000;

        while (e - s > 1){
            int m = (e + s) / 2;

            if (test(distance, rocks, n, m)) s = m;
            else e = m;
        }

        return s;
    }

    public boolean test(int d, int[] rocks,int n, int m) {

        int now = 0;
        int count = 0;

        for (int rock : rocks) {
            if (rock - now >= m) now = rock;
            else count++;

            if (count > n) return false;
        }

        if (d - now < m) count++;

        return (count <= n);
    }
}