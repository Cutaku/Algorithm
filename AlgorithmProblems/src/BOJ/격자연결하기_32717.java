package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 격자연결하기_32717 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] right = new int[n][m];
        int[][] left = new int[n][m];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int add = 0;

                if (i > 0) add = Math.max(add, right[i - 1][j]);
                if (j > 0) add = Math.max(add, right[i][j - 1]);

                max = Math.max(max, right[i][j] = add + board[i][j]);
            }

            for (int j = m - 1; j >= 0; j--) {
                int add = 0;

                if (i > 0) add = Math.max(add, left[i - 1][j]);
                if (j < m - 1) add = Math.max(add, left[i][j + 1]);

                max = Math.max(max, left[i][j] = add + board[i][j]);
            }
        }

        System.out.println(max);
    }
}