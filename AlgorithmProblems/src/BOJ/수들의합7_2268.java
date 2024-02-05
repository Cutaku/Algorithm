package BOJ;

import java.io.*;
import java.util.Arrays;

public class 수들의합7_2268 {
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int l = 1;

        while (n > l) l *= 2;
        l *= 2;

        arr = new int[l + 1];
        tree = new long[l + 1];

        for (int i = 0; i < m; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (query[0] == 0) {
                bw.append(String.format("%d\n", sum(1, 1, n, Math.min(query[1], query[2]), Math.max(query[1], query[2]))));
            } else {
                int dif = query[2] - arr[query[1]];

                arr[query[1]] = query[2];

                modify(1, 1, n, query[1], dif);
            }
        }

        bw.flush();
    }

    static long sum(int t, int left , int right, int i, int j) {

        if (left > j || right < i) return 0;
        if (i <= left && right <= j) return tree[t];

        int m = (left + right) / 2;
        return sum(2 * t, left, m, i, j) + sum(2 * t + 1, m + 1, right, i , j);
    }

    static void modify(int t, int left, int right, int i, int num) {

        if (left > i || right < i) return;
        tree[t] += num;
        if (left == right) return;

        int m = (left + right) / 2;
        modify(2 * t, left, m, i, num);
        modify(2 * t + 1, m + 1, right, i, num);
    }
}