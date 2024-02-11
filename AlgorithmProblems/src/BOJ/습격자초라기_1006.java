package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 습격자초라기_1006 {
    static int n, w;
    static int[][] sectors;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] nw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nw[0];
            w = nw[1];

            sectors = new int[2][];
            for (int i = 0; i < 2; i++) {
                sectors[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int min = 2 * n;

            int[] dp = {2, 2 * n, 2 * n, 2 * n};
            if (sectors[0][0] + sectors[1][0] <= w) dp[3] = 1;
            min = Math.min(min, findMin(dp, false, false));

            if (n > 1 && sectors[0][0] + sectors[0][n - 1] <= w) {
                dp = new int[]{2 * n, 2, 2 * n, 2 * n};
                min = Math.min(min, findMin(dp, true, false));
            }

            if (n > 1 && sectors[1][0] + sectors[1][n - 1] <= w) {
                dp = new int[]{2 * n, 2 * n, 2, 2 * n};
                min = Math.min(min, findMin(dp, false, true));
            }

            if (n > 1 && sectors[0][0] + sectors[0][n - 1] <= w && sectors[1][0] + sectors[1][n - 1] <= w) {
                dp = new int[]{2 * n, 2 * n, 2 * n, 2};
                min = Math.min(min, findMin(dp, true, true));
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static int findMin(int[] dp, boolean inner, boolean outer) {

        int[] temp;

        for (int i = 1; i < n; i++) {
            temp = new int[]{2 * n, 2 * n, 2 * n, 2 * n};

            temp[0] = Math.min(Math.min(dp[0], dp[1]), Math.min(dp[2], dp[3])) + 2;

            if (sectors[0][i - 1] + sectors[0][i] <= w) {
                temp[1] = Math.min(dp[0], dp[2]) + 1;
            }

            if (sectors[1][i - 1] + sectors[1][i] <= w) {
                temp[2] = Math.min(dp[0], dp[1]) + 1;
            }

            if (sectors[0][i] + sectors[1][i] <= w) {
                temp[3] = temp[0] - 1;
            }

            if (sectors[0][i  -1] + sectors[0][i] <= w && sectors[1][i - 1] + sectors[1][i] <= w) {
                temp[3] = Math.min(temp[3], dp[0]);
            }

            dp = temp;
        }

        if (!inner && !outer) return Math.min(Math.min(dp[0], dp[1]), Math.min(dp[2], dp[3]));
        if (inner && !outer) return Math.min(dp[0], dp[2]) - 1;
        if (!inner) return Math.min(dp[0], dp[1]) - 1;
        return dp[0] - 2;
    }
}