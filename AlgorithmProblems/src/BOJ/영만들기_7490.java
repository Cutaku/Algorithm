package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영만들기_7490 {
    static int n;
    static char[] op = new char[9];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder a = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String[] ans = new String[10];

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            if (ans[n] == null) {
                sb = new StringBuilder();
                dfs(1, 1, 1);
                ans[n] = sb.toString();
            }

            a.append(ans[n]).append('\n');
        }

        System.out.println(a);
    }

    static void dfs(int d, int sum, int last) {

        if (d == n) {
            if (sum == 0) {
                for (int i = 1; i < n; i++) sb.append(i).append(op[i]);
                sb.append(n).append("\n");
            }

            return;
        }

        int l = 10 * last + (last > 0 ? 1 : -1) * (d + 1);

        op[d] = ' ';
        dfs(d + 1, sum - last + l, l);

        op[d] = '+';
        dfs(d + 1, sum + d + 1, d + 1);

        op[d] = '-';
        dfs(d + 1, sum - d - 1, -d - 1);
    }
}