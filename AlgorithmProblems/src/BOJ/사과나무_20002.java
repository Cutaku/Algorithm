package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과나무_20002 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] sum = new int[n + 1][n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int d = 1; d <= n; d++) {
            for (int i = 0; i + d <= n; i++) {
                for (int j = 0; j + d <= n; j++) {
                    max = Math.max(max, sum[i + d][j + d] - sum[i + d][j] - sum[i][j + d] + sum[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}