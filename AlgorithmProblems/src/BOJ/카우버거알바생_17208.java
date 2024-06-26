package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카우버거알바생_17208 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[m + 1][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = m; j >= x; j--) {
                for (int l = k; l >= y; l--) {
                 dp[j][l] = Math.max(dp[j][l], dp[j - x][l - y] + 1);
                }
            }
        }

        System.out.println(dp[m][k]);
    }
}