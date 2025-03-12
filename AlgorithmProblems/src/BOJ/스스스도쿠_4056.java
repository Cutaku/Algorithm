package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스스스도쿠_4056 {
    static int[] bit = new int[257];
    static int[][] board;
    static int[] row;
    static int[] col;
    static int[][] sec;
    static int[] empty = new int[5];
    static int t = (1 << 9) - 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) bit[1 << i] = i;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            board = new int[9][9];
            row = new int[9];
            col = new int[9];
            sec = new int[3][3];

            int idx = 0;

            for (int i = 0; i < 9; i++) {
                String line = br.readLine();

                for (int j = 0; j < 9; j++) {
                    board[i][j] = line.charAt(j) - '1';

                    if (board[i][j] == -1) {
                        empty[idx++] = 9 * i + j;
                    } else {
                        row[i] |= 1 << board[i][j];
                        col[j] |= 1 << board[i][j];
                        sec[i / 3][j / 3] |= 1 << board[i][j];
                    }
                }
            }

            if (dfs(0)) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(board[i][j] + 1);
                    }

                    sb.append("\n");
                }
            } else {
                sb.append("Could not complete this grid.\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean dfs(int d) {

        if (d == 5) {
            int left = 511;

            for (int i = 0; i < 9; i++) {
                left &= row[i];
                left &= col[i];
                left &= sec[i / 3][i % 3];
            }

            return left == 511;
        }

        int r = empty[d] / 9, c = empty[d] % 9;
        int able = t & ~(row[r] | col[c] | sec[r / 3][c / 3]);

        while (able > 0) {
            int b = able & -able;
            able -= b;

            board[r][c] = bit[b];

            row[r] |= b;
            col[c] |= b;
            sec[r / 3][c / 3] |= b;

            if (dfs(d + 1)) return true;

            row[r] |= ~b;
            col[c] |= ~b;
            sec[r / 3][c / 3] |= ~b;
        }

        return false;
    }
}