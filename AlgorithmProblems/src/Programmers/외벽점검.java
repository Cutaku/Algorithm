package Programmers;

import java.util.*;

class 외벽점검 {

    static List<int[]> list;
    static boolean[] used;

    public int solution(int n, int[] weak, int[] dist) {

        int l = dist.length;

        list = new ArrayList<>();
        used = new boolean[l];

        for (int i = 0; i < l; i++) {

            int[] arr = new int[l];
            arr[0] = dist[i];

            used[i] = true;
            dfs(arr, dist, 1, l);
            used[i] = false;
        }

        l = weak.length;
        for (int i = l - 1; i >= 0; i--) weak[i] -= weak[0];

        int[][] weaks = new int[l][];
        for (int i = 0; i < l; i++) {

            int[] temp = new int[l];
            for (int j = 0; j < l; j++) temp[j] = weak[j];

            weaks[i] = temp;

            for (int j = 0; j < l - 1; j++) weak[j] = weak[j + 1];
            weak[l - 1] = n;
            for (int j = l - 1; j >= 0; j--) weak[j] -= weak[0];
        }

        int min = dist.length;
        boolean flag = false;

        for (int[] w : weaks) {
            for (int[] d : list) {

                int cover = d[0];

                int i = 0;
                int j = 1;

                while (i < d.length && j < w.length) {
                    if (cover >= w[j]) {
                        j++;
                    } else {
                        i++;

                        if (i < d.length) cover = w[j] + d[i];
                    }
                }

                if (j >= w.length) {
                    min = Math.min(min, i + 1);
                    flag = true;
                }
            }
        }

        if (flag) return min;
        else return -1;
    }

    public void dfs(int[] arr, int[] dist, int d, int l) {

        if (d == l) {
            int[] temp = new int[l];
            for (int i = 0; i < l; i++) temp[i] = arr[i];
            list.add(temp);
            return;
        }

        for (int i = 0; i < l; i++) {
            if (used[i]) continue;

            arr[d] = dist[i];
            used[i] = true;
            dfs(arr, dist, d + 1, l);
            arr[d] = 0;
            used[i] = false;
        }
    }
}