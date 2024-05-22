package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DanceDanceRevolution_2342 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] cost = {{1, 2, 2, 2, 2}, {0, 1, 3, 4, 3}, {0, 3, 1, 3, 4}, {0, 4, 3, 1, 3}, {0, 3, 4, 3, 1}};

        int p;

        int[][] dp = new int[5][5];
        for (int i = 0; i < 5; i++) Arrays.fill(dp[i], 500000);
        dp[0][0] = 0;

        while ((p = Integer.parseInt(st.nextToken())) > 0) {
            int[][] temp = new int[5][5];
            for (int i = 0; i < 5; i++) Arrays.fill(temp[i], 500000);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp[i][p] = Math.min(temp[i][p], dp[i][j] + cost[j][p]);
                    temp[p][i] = Math.min(temp[p][i], dp[j][i] + cost[j][p]);
                }
            }

            dp = temp;
        }

        int min = 500000;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[i][j]);
            }
        }

        System.out.println(min);
    }
}