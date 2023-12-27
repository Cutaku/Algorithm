package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 수도쿠검증_1974 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[][] board = new int[9][];

            for (int i = 0; i < 9; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(isValid(board))).append("\n");
        }

        bw.flush();
    }

    public static int isValid(int[][] board) {

        boolean[] used;

        for (int i = 0; i < 9; i++) {
            used = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (used[board[i][j]]) return 0;
                used[board[i][j]] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            used = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (used[board[j][i]]) return 0;
                used[board[j][i]] = true;
            }
        }

        for (int i = 0; i < 9; i++) {
            used = new boolean[10];

            for (int j = 0; j < 9; j++) {
                if (used[board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]]) return 0;
                used[board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]] = true;
            }
        }

        return 1;
    }
}