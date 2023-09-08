package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 체스판다시칠하기2_25682 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        int[][] count = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (((i + j) % 2 == 0 && board[i - 1][j - 1] == 'W') || ((i + j) % 2 == 1 && board[i - 1][j - 1] == 'B')) {
                    count[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                count[i][j] += count[i][j - 1];
            }
        }

        for (int j = 1; j <= m; j++) {
            for (int i = 2; i <= n; i++) {
                count[i][j] += count[i - 1][j];
            }
        }

        int min = k * k;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int c = count[i][j] - count[i][j - k] - count[i - k][j] + count[i - k][j - k];

                min = Math.min(min , Math.min(c, k * k - c));
            }
        }

        System.out.println(min);
    }
}