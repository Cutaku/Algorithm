package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {
    static int n;
    static int cnt;
    static int ans;
    static boolean[] used;
    static boolean[] d1;
    static boolean[] d2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cnt = 0;
        ans = 0;
        used = new boolean[n];
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int d) {

        if (n == d) {
            cnt++;
            return;
        }
        if (d > 0) {
            for (int i = 0; i < n; i++) {
                if (used[i] || d1[d + i] || d2[d - i + n - 1]) continue;
                check(d, i);
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                check(d, i);
            }

            ans += cnt;

            if (n % 2 == 1) {
                check(d, n / 2);
            }

            ans += cnt;
        }
    }

    static void check(int d, int i) {
        used[i] = true;
        d1[d + i] = true;
        d2[d - i + n - 1] = true;

        dfs(d + 1);

        used[i] = false;
        d1[d + i] = false;
        d2[d - i + n - 1] = false;
    }
}