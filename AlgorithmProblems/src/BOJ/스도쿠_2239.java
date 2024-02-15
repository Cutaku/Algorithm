package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 스도쿠_2239 {
    static int[] row = new int[9];
    static int[] col = new int[9];
    static int[][] sec = new int[3][3];
    static int[][] sudoku = new int[9][9];
    static List<int[]> zeros = new ArrayList<>();
    static int l;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();

            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = line.charAt(j) - '1';

                if (sudoku[i][j] > -1) {
                    row[i] |= 1 << sudoku[i][j];
                    col[j] |= 1 << sudoku[i][j];
                    sec[i / 3][j / 3] |= 1 << sudoku[i][j];
                } else {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        l = zeros.size();

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j] + 1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean dfs(int d) {

        if (d == l) return true;

        int[] rc = zeros.get(d);
        int r = rc[0], c = rc[1];

        int able = ((1 << 9) - 1) & ~(row[r] | col[c] | sec[r / 3][c / 3]);

        int i = 0;

        while (able > 0) {
            int p = able & -able;
            able -= p;

            while (p > (1 << i)) i++;
            sudoku[r][c] = i;

            row[r] |= p;
            col[c] |= p;
            sec[r / 3][c / 3] |= p;

            if (dfs(d + 1)) return true;

            row[r] &= ~p;
            col[c] &= ~p;
            sec[r / 3][c / 3] &= ~p;
        }

        return false;
    }
}