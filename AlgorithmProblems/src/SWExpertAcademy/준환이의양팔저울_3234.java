package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 준환이의양팔저울_3234 {
    static int n;
    static int[] weights;
    static int[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');

            n = Integer.parseInt(br.readLine());
            weights = new int[1 << n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                weights[1 << i] = Integer.parseInt(st.nextToken());
            }

            memo = new int[1 << n][1 << n];

            sb.append(dfs((1 << n) - 1, 0, 0, 0, 0)).append("\n");
        }

        System.out.println(sb);
    }

    static int dfs(int able, int left, int right, int lv, int rv) {

        if (able == 0) {
            return 1;
        }

        if (memo[lv][rv] > 0) {
            return memo[lv][rv];
        }

        int temp = able;

        int res = 0;

        while (able > 0) {
            int p = able & -able;
            able -= p;

            int w = weights[p];

            res += dfs(temp - p, left + w, right, lv + p, rv);
            if (left >= right + w) res += dfs(temp - p, left, right + w, lv, rv + p);
        }

        return memo[lv][rv] = res;
    }
}