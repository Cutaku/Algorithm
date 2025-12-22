package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호_15668 {
    static int n, m;
    static int[] toIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = (n - 1) / 2;

        toIdx = new int[513];
        for (int i = 0; i < 10; i++) toIdx[1 << i] = i;


        for (int i = 1; i < 10; i++) {
            dfs(i, 1 << i);
        }

        System.out.println(-1);
    }

    static void dfs(int sum, int b) {

        if (sum > m) return;

        int a = n - sum;

        if (check(a, b)) {
            System.out.println(sum + " + " + a);
            System.exit(0);
        }

        int pos = 511 - b;

        while (pos > 0) {
            int q = pos & -pos;
            pos -= q;

            dfs(10 * sum + toIdx[q], b + q);
        }
    }

    static boolean check(int a, int b) {

        while (a > 0) {
            int c = 1 << (a % 10);

            if ((b & c) > 0) return false;
            b |= c;
            a /= 10;
        }

        return true;
    }
}