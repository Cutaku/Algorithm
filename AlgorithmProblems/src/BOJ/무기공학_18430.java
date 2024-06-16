package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무기공학_18430 {
    static int n, m;
    static int[][] board;
    static boolean[][] used;
    static int sum, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        used = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum = 0;
        max = 0;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int d, int sum){
        if (d == n * m) {
            max = Math.max(max, sum);
            return;
        }

        int r = d / m;
        int c = d % m;

        dfs(d + 1, sum);

        if (used[r][c]) return;

        used[r][c] = true;

        if (r > 0 && !used[r - 1][c]) {
            used[r - 1][c] = true;

            if (c > 0 && !used[r][c - 1]) {
                used[r][c - 1] = true;
                dfs(d + 1, sum + 2 * board[r][c] + board[r - 1][c] + board[r][c - 1]);
                used[r][c - 1] = false;
            }

            if (c < m - 1 && !used[r][c + 1]) {
                used[r][c + 1] = true;
                dfs(d + 1, sum + 2 * board[r][c] + board[r - 1][c] + board[r][c + 1]);
                used[r][c + 1] = false;
            }

            used[r - 1][c] = false;
        }

        if (r < n - 1 && !used[r + 1][c]) {
            used[r + 1][c] = true;

            if (c > 0 && !used[r][c - 1]) {
                used[r][c - 1] = true;
                dfs(d + 1, sum + 2 * board[r][c] + board[r + 1][c] + board[r][c - 1]);
                used[r][c - 1] = false;
            }

            if (c < m - 1 && !used[r][c + 1]) {
                used[r][c + 1] = true;
                dfs(d + 1, sum + 2 * board[r][c] + board[r + 1][c] + board[r][c + 1]);
                used[r][c + 1] = false;
            }

            used[r + 1][c] = false;
        }

        used[r][c] = false;
    }
}