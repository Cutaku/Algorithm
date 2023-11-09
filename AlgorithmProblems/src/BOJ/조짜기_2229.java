package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 조짜기_2229 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] abilities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.abs(abilities[i] - abilities[i + 1]);
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int min = 10000;
                int max = 0;

                for (int j = i; j <= i + d; j++) {
                    min =  Math.min(min, abilities[j]);
                    max =  Math.max(max, abilities[j]);
                }

                dp[i][i + d] = max - min;

                for (int j = i; j < i + d; j++) {
                    dp[i][i + d] = Math.max(dp[i][i + d], dp[i][j] + dp[j + 1][i + d]);
                }
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}