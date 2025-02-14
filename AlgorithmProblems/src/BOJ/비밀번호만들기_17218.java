package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호만들기_17218 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int l1 = str1.length();
        int l2 = str2.length();
        String[][] dp = new String[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) dp[i][0] = "";
        for (int i = 1; i <= l2; i++) dp[0][i] = "";

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + str1.charAt(i);
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j].length() > dp[i][j + 1].length() ? dp[i + 1][j] : dp[i][j + 1];
                }
            }
        }

        System.out.println(dp[l1][l2]);
    }
}