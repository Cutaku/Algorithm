package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이차원배열과연산_17140 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rck = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rck[0], c = rck[1], k = rck[2];

        int[][] arr = new int[3][];
        for (int i = 0; i < 3; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (r <= 3 && c <= 3 && arr[r - 1][c - 1] == k) {
            System.out.println(0);
            return;
        }

        for (int t = 1; t < 101; t++) {
            if (arr.length >= arr[0].length)  arr = operate(arr);
            else  arr = reflect(operate(reflect(arr)));

            if (r > arr.length || c > arr[0].length) continue;

            if (arr[r - 1][c - 1] == k) {
                System.out.println(t);
                return;
            }
        }

        System.out.println(-1);
    }

    static int[][] operate(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int[][] result = new int[n][];

        Map<Integer, Integer>[] maps = new Map[n];
        for (int i = 0; i < n; i++) maps[i] = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;

                try {
                    maps[i].compute(arr[i][j], (k, v) -> v + 1);
                } catch (NullPointerException e) {
                    maps[i].put(arr[i][j], 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, maps[i].size());
        }

        for (int i = 0; i < n; i++) {
            PriorityQueue<Count> pq = new PriorityQueue<>();

            for (int key : maps[i].keySet()) {
                pq.add(new Count(key, maps[i].get(key)));
            }

            result[i] = new int[2 * max];

            int j = 0;

            while (!pq.isEmpty()) {
                Count count = pq.poll();

                result[i][j++] = count.num;
                result[i][j++] = count.count;
            }
        }

        return result;
    }

    static int[][] reflect(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = arr[i][j];
            }
        }

        return result;
    }

    static class Count implements Comparable<Count> {
        int num;
        int count;

        public Count(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Count c) {
            if (this.count > c.count) return 1;
            else if (this.count < c.count) return -1;
            else if (this.num > c.num) return 1;
            else if (this.num < c.num) return -1;
            return 0;
        }
    }
}