package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장큰정사각형_1915 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] board = new int[n][];

        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, board[i][0]);
        }

        for (int i = 0; i < m; i++) {
            max = Math.max(max, board[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 0) continue;

                board[i][j] += Math.min(board[i - 1][j - 1], Math.min(board[i][j - 1], board[i - 1][j]));

                max = Math.max(max, board[i][j]);
            }
        }

        System.out.println(max * max);
    }
}