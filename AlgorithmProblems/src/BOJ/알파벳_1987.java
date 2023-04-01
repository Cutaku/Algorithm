package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알파벳_1987 {
    static char[][] board;
    static boolean[] used;
    static int max;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];

        board = new char[r][];
        for (int i = 0; i < r; i++) board[i] = br.readLine().toCharArray();

        used = new boolean['Z' + 1];

        max = 0;

        used[board[0][0]] = true;
        dfs(new int[] {0, 0}, 1);

        System.out.println(max);
    }

    static void dfs(int[] cord, int dept) {

        int r = board.length;
        int c = board[0].length;

        boolean fin = true;

        int[][] D = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] d : D) {
            int i = cord[0] + d[0];
            int j = cord[1] + d[1];

            if (i < 0 || j < 0 || i >= r || j >= c) continue;

            char a = board[i][j];
            if (used[a]) continue;

            fin = false;

            used[a] = true;
            dfs(new int[] {i, j}, dept + 1);
            used[a] = false;
        }

        if (fin) max = Math.max(max, dept);
    }
}