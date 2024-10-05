package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 순열장난_10597 {
    static int n, l;
    static int[] file;
    static boolean[] used;
    static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        l = line.length();

        file = new int[l];
        for (int i = 0; i < l; i++) file[i] = line.charAt(i) - '0';

        if (l <= 9) n = l;
        else n = 9 + (l - 9) / 2;

        used = new boolean[n];
        ans = new int[n];

        dfs(0, 0);
    }

    static void dfs(int d, int i) {

        if (i == l) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[j] + " ");
            }

            System.exit(0);
        }

        int a = file[i];

        if (a > 0 && a <= n && !used[a - 1]) {
            used[a - 1] = true;
            ans[d] = a;
            dfs(d + 1, i + 1);
            used[a - 1] = false;
        }

        if (i < l - 1) {
            a = 10 * a + file[i + 1];
            if (a > 0 && a <= n && !used[a - 1]) {
                used[a - 1] = true;
                ans[d] = a;
                dfs(d + 1, i + 2);
                used[a - 1] = false;
            }
        }
    }
}