package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 봄버맨2_16919 {
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {0, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append("O");
                }

                sb.append("\n");
            }

            System.out.println(sb);
            return;
        }

        char[][] board = new char[r][];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (n % 4 == 3) {
            board = reverse(board);
        }

        if (n > 1 && n % 4 == 1) {
            board = reverse(reverse(board));
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(board[i][j]);
            }

            sb.append("\n");
        }


        System.out.println(sb);
    }

    static char[][] reverse(char[][] board) {

        int r = board.length, c = board[0].length;

        char[][] result = new char[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(result[i], 'O');

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    for (int[] d : D) {
                        int x = i + d[0], y = j + d[1];

                        if (x < 0 || y < 0 || x >= r || y >= c) continue;

                        result[x][y] = '.';
                    }
                }
            }
        }

        return result;
    }
}