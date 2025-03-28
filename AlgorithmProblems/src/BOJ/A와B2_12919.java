package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {
    static char[] S, T;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().toCharArray();
        T = br.readLine().toCharArray();

        dfs(0, 0, T.length - 1, 1);

        System.out.println(0);
    }

    static void dfs(int d, int s, int e, int dir) {

        if (d == T.length - S.length) {
            if (compare(s, dir)) {
                System.out.println(1);
                System.exit(0);
            }

            return;
        }

        if (T[e] == 'A') dfs(d + 1, s, e - dir, dir);
        if (T[s] == 'B') dfs(d + 1, e, s + dir, dir * -1);
    }

    static boolean compare(int s, int dir) {

        for (int i = 0; i < S.length; i++) {
            if (S[i] != T[s + i * dir]) return false;
        }

        return true;
    }
}