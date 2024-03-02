package BOJ;

import java.io.*;
import java.util.*;

public class Hard2048_12094 {
    static int n;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        max = 0;

        dfs(board, 0);

        System.out.println(max);
    }

    static void dfs(int[][] board, int d) {

        if (d == 10) {
            findMax(board);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] temp = copy(board);
            left(board);
            dfs(board, d + 1);
            board = temp;
            rotate(board);
        }
    }

    static void findMax(int[][] board) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }

    static void left(int[][] board) {
        for (int i = 0; i < n; i++) {
            int k = 0;

            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0) continue;

                if (board[i][k] == 0) {
                    board[i][k] = board[i][j];
                    board[i][j] = 0;
                } else if (board[i][j] == board[i][k]) {
                    board[i][k++] *= 2;
                    board[i][j] = 0;
                } else {
                    board[i][++k] = board[i][j];
                    if (k < j) board[i][j] = 0;
                }
            }
        }
    }

    static void rotate(int[][] board) {

        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board[n - 1 - j][i];
            }
        }

        for (int i = 0; i < n; i++) board[i] = temp[i].clone();
    }

    static int[][] copy(int[][] board) {

        int[][] result = new int[n][];
        for (int i = 0; i < n; i++)  result[i] = board[i].clone();

        return result;
    }
}