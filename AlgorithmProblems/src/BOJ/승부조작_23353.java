package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 승부조작_23353 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 2][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            int c1 = 0, c2 = 0;

            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 0) {
                    c1 = 0;
                    c2 = 0;
                } else if (board[i][j] == 1) {
                    c1++;
                    c2++;
                } else {
                    c2 = c1 + 1;
                    c1 = 0;
                }

                max = Math.max(max, c2);
            }
        }

        for (int j = 1; j <= n; j++) {
            int c1 = 0, c2 = 0;

            for (int i = 1; i <= n; i++) {
                if (board[i][j] == 0) {
                    c1 = 0;
                    c2 = 0;
                } else if (board[i][j] == 1) {
                    c1++;
                    c2++;
                } else {
                    c2 = c1 + 1;
                    c1 = 0;
                }

                max = Math.max(max, c2);
            }
        }

        for (int i = -n + 1; i < n; i++) {
            int c1 = 0, c2 = 0;

            for (int j = 0; j < n - Math.abs(i); j++) {
                int a = board[Math.max(1, 1 - i) + j][Math.max(1, i + 1) + j];

                if (a == 0) {
                    c1 = 0;
                    c2 = 0;
                } else if (a == 1) {
                    c1++;
                    c2++;
                } else {
                    c2 = c1 + 1;
                    c1 = 0;
                }

                max = Math.max(max, c2);
            }
        }

        for (int i = -n + 1; i < n; i++) {
            int c1 = 0, c2 = 0;

            for (int j = 0; j < n - Math.abs(i); j++) {
                int a = board[Math.min(n, n + i) - j][Math.max(1, i + 1) + j];

                if (a == 0) {
                    c1 = 0;
                    c2 = 0;
                } else if (a == 1) {
                    c1++;
                    c2++;
                } else {
                    c2 = c1 + 1;
                    c1 = 0;
                }

                max = Math.max(max, c2);

            }
        }

        System.out.println(max);
    }
}