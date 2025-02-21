package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수따먹기_1749 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n + 1][m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix[i][j] = matrix[i - 1][j] + Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = matrix[j][0] - matrix[i - 1][0];
                int idx = 1;
                max = Math.max(max, sum);

                while (idx < m) {
                    sum += matrix[j][idx] - matrix[i - 1][idx++];
                    max = Math.max(max, sum);
                    sum = Math.max(sum, 0);
                }
            }
        }

        System.out.println(max);
    }
}