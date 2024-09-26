package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬개수구하기_small_14505 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String word = br.readLine();
        int l = word.length();

        int[][] dp = new int[l][l];

        dp[0][0] = 1;

        for (int i = 1; i < l; i++) {
            dp[i][i] = 1;
            dp[i - 1][i] = word.charAt(i - 1) == word.charAt(i) ? 3 : 2;
        }

        for (int d = 2; d < l; d++) {
            for (int i = 0; i + d < l; i++) {
                dp[i][i + d] = dp[i + 1][i + d] + dp[i][i + d - 1]
                        + (word.charAt(i) == word.charAt(i + d) ? 1 : -1 * dp[i + 1][i + d - 1]);
            }
        }

        System.out.println(dp[0][l - 1]);
    }
}