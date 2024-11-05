package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingOfPermutations_8120 {
    static int n;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = find(n - 1 - i, arr[i]);
            add(ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ans[i]).append("\n");

        System.out.println(sb);
    }

    static void add(int i) {

        while (i <= n) {
            tree[i]++;
            i += i & -i;
        }
    }

    static int sum(int i) {

        int sum = 0;

        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }

        return sum;
    }

    static int find(int i, int j) {

        if (i + j >= n) {
            System.out.println("NIE");
            System.exit(0);
        }

        int s = 0, e = n;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (n - m - i + sum(m) <= j) e = m;
            else s = m;
        }

        return e;
    }
}