package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇조종하기_2169 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] mars = new int[n][];
        for (int i = 0; i < n; i++) mars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] sum = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            sum[1][i] = sum[1][i - 1] + mars[0][i - 1];
        }

        for (int i = 2; i <= n; i++) {
            int[] left = new int[m + 1];
            int[] right = new int[m + 2];

            Arrays.fill(left, Integer.MIN_VALUE);
            Arrays.fill(right, Integer.MIN_VALUE);

            for (int j = 1; j <= m; j++) {
                left[j] = Math.max(left[j - 1], sum[i - 1][j]) + mars[i - 1][j - 1];
            }

            for (int j = m; j > 0; j--) {
                right[j] = Math.max(right[j + 1], sum[i - 1][j]) + mars[i - 1][j - 1];
            }

            for (int j = 1; j <= m; j++) {
                sum[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(sum[n][m]);
    }
}