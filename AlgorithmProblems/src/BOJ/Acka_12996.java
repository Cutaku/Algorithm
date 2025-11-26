package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acka_12996 {
    static int d = 1000000007;
    static int[][][][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        memo = new int[s + 1][a + 1][b + 1][c + 1];

        System.out.println(count(s, a, b, c));
    }

    static int count(int s, int a, int b, int c) {

        if (a < 0 || b < 0 || c < 0) return 0;

        if (memo[s][a][b][c] > 0) return memo[s][a][b][c] - 1;

        if (a > s || b > s || c > s || s > a + b + c) return 0;

        if (s == 1) return 1;

        int res = count(s - 1, a - 1, b, c);
        res = (res + count(s - 1, a, b - 1, c)) % d;
        res = (res + count(s - 1, a, b, c - 1)) % d;
        res = (res + count(s - 1, a - 1, b - 1, c)) % d;
        res = (res + count(s - 1, a - 1, b, c - 1)) % d;
        res = (res + count(s - 1, a, b - 1, c - 1)) % d;
        res = (res + count(s - 1, a - 1, b - 1, c - 1)) % d;

        memo[s][a][b][c] = res + 1;

        return res;
    }
}