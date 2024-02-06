package BOJ;

import java.io.*;
import java.util.Arrays;

public class 수들의합7_2268 {
    static int n;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        int m = nm[1];

        arr = new int[n + 1];
        tree = new long[n + 1];

        for (int i = 0; i < m; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (query[0] == 0) {
                sb.append(sum(Math.max(query[1], query[2])) - sum(Math.min(query[1], query[2]) - 1)).append("\n");
            } else {
                modify(query[1], query[2]);
            }
        }

        System.out.println(sb);
    }

    static void modify(int i, int num) {

        int d = num - arr[i];
        arr[i] = num;

        while (i <= n) {
            tree[i] += d;
            i += i & -i;
        }
    }

    static long sum(int i) {

        long sum = 0;

        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }

        return sum;
    }
}