package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 붕어빵타이쿤_1704 {
    static int m, n;
    static int count;
    static int[] board;
    static int[][] d = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i] += Integer.parseInt(st.nextToken()) << (n - 1 - j);
            }
        }

        int[] bitToInt = new int[(1 << (n - 1)) + 1];
        for (int i = 0; i < n; i++) bitToInt[1 << i] = i;

        int[] ans = new int[m];

        int min = Integer.MAX_VALUE;
        int[] minAns = null;

        for (int i = 0; i < (1 << n); i++) {
            int[] temp = board.clone();
            count = 0;

            ans[0] = i;

            int b = i;

            while (b > 0) {
                int p = b & -b;
                b -= p;

                turn(0, bitToInt[p]);
            }

            for (int j = 0; j < m - 1; j++) {
                while (board[j] > 0) {
                    int p = board[j] & -board[j];

                    turn (j + 1, bitToInt[p]);
                    ans[j + 1] += p;
                }
            }

            if (board[m - 1] == 0 && count < min) {
                min = count;
                minAns = ans.clone();
            }

            board = temp;
            Arrays.fill(ans, 0);
        }

        if (minAns == null) System.out.println("IMPOSSIBLE");
        else {
            for (int i = 0; i < m; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if ((minAns[i] & (1 << j)) > 0) sb.append(1).append(" ");
                    else sb.append(0).append(" ");
                }

                sb.append("\n");
            }

            System.out.println(sb);
        }
    }

    static void turn(int r, int c) {

        count++;

        for (int i = 0; i < 5; i++) {
            int x = r + d[i][0];
            int y = c + d[i][1];

            if (x < 0 || y < 0 || x >= m || y >= n) continue;

            board[x] ^= 1 << y;
        }
    }
}