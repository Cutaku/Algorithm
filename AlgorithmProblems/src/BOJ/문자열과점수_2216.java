package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열과점수_2216 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String x = br.readLine();
        String y = br.readLine();

        int l1 = x.length();
        int l2 = y.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) dp[i][0] = i * b;
        for (int i = 1; i <= l2; i++) dp[0][i] = i * b;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + (x.charAt(i - 1) == y.charAt(j - 1) ? a : c),
                        Math.max(dp[i - 1][j], dp[i][j - 1]) + b);
            }
        }

        System.out.println(dp[l1][l2]);
    }
}