package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 스도쿠_2239 {
    static int[][] board;
    static List<int[]> blank;
    static boolean[][] hori;
    static boolean[][] vert;
    static boolean[][][] sect;
    static boolean fin;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][];
        for (int i = 0; i < 9; i++) board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        blank = new ArrayList<>();
        hori = new boolean[9][10];
        vert = new boolean[9][10];
        sect = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > 0) {
                    hori[i][board[i][j]] = true;
                    vert[j][board[i][j]] = true;
                    sect[i / 3][j / 3][board[i][j]] = true;
                } else {
                    blank.add(new int[]{i, j});
                }
            }
        }

        fin = false;

        dfs(0);
    }

    public static void dfs(int n) {

        if (fin) return;

        if (n == blank.size()) {
            fin = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }

                System.out.println();
            }

            return;
        }

        int[] now = blank.get(n);
        int x = now[0], y = now[1];

        for (int i = 1; i < 10; i++) {
            if (fin) return;

            if (hori[x][i] || vert[y][i] || sect[x / 3][y / 3][i]) continue;

            board[x][y] = i;
            hori[x][i] = true;
            vert[y][i] = true;
            sect[x / 3][y / 3][i] = true;

            dfs(n + 1);

            board[x][y] = 0;
            hori[x][i] = false;
            vert[y][i] = false;
            sect[x / 3][y / 3][i] = false;
        }
    }
}