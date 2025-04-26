package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 생명게임_17232 {
    static int n, m, t, k, a, b;
    static boolean[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) == '*';
            }
        }

        for (int i = 0; i < t; i++) {
            next();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j] ? "*" : ".");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void next() {

        int[][] count = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[i + 1][j + 1] = count[i + 1][j] + (board[i][j] ? 1 : 0);
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                count[i][j] += count[i - 1][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int r1 = Math.max(0, i - k - 1), r2 = Math.min(n, i + k);
                int c1 = Math.max(0, j - k - 1), c2 = Math.min(m, j + k);

                int cnt = count[r2][c2] - count[r1][c2] - count[r2][c1] + count[r1][c1];

                if (board[i - 1][j - 1]) {
                    cnt--;
                    if (cnt < a || cnt > b) board[i - 1][j - 1] = false;
                } else {
                    if (a < cnt && cnt <= b) board[i - 1][j - 1] = true;
                }
            }
        }
    }
}