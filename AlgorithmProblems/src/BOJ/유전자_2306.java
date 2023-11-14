package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유전자_2306 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] dna = br.readLine().toCharArray();

        int n = dna.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            if ((dna[i] == 'a' && dna[i + 1] == 't') || (dna[i] == 'g' && dna[i + 1] == 'c')) {
                dp[i][i + 1] = 2;
            }
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                dp[i][i + d] = Math.max(dp[i][i + d - 1], dp[i + 1][i + d]);

                if (dna[i] == 'a' && dna[i + d] == 't') {
                    dp[i][i + d] = Math.max(dp[i][i + d], dp[i + 1][i + d - 1] + 2);
                }

                if (dna[i] == 'g' && dna[i + d] == 'c') {
                    dp[i][i + d] = Math.max(dp[i][i + d], dp[i + 1][i + d - 1] + 2);
                }

                for (int j = 1; j < d - 1; j++) {
                    dp[i][i + d] = Math.max(dp[i][i + d], dp[i][i + j] + dp[i + j + 1][i + d]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}