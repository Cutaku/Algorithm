package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 공_2695 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        dp = new int[51][1001];

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());

            sb.append(dp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int dp(int b, int m) {

        if (m == 0) return 0;
        if (b == 0) return 1001;
        if (b == 1) return m;

        if (dp[b][m] > 0) return dp[b][m];

        int res = 1001;

        for (int i = 1; i <= m; i++) {
            res = Math.min(res, Math.max(dp(b - 1, i - 1), dp(b, m - i)));
        }

        return dp[b][m] = res + 1;
    }
}
