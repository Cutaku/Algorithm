package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_bit_9663 {
    static int n;
    static int cnt, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cnt = 0;
        ans = 0;

        dfs(0, 0, 0, 0);

        System.out.println(ans);
    }

    static void dfs(int row, int c, int d1, int d2) {

        if(row == n) {
            cnt++;
            return;
        }

        if (row > 0) {
            int able = ((1 << n) - 1) & ~(c | d1 | d2);

            while (able > 0) {
                int p = able & -able;
                able -= p;

                nextDfs(row, c, d1, d2, p);
            }
        } else {
            for (int i = 0; i < n / 2; i++) nextDfs(row, c, d1, d2, 1 << i);
            ans += cnt;

            if (n % 2 == 1) nextDfs(row, c, d1, d2, 1 << (n / 2));
            ans += cnt;
        }
    }

    static void nextDfs(int row, int c, int d1, int d2, int p) {
        dfs(row + 1, c | p, (d1 | p) >> 1, (d2 | p) << 1);
    }
}