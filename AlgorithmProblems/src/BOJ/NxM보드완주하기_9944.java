package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class NxM보드완주하기_9944 {
    static int n, m;
    static int[] board;
    static int count;
    static int min;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        String input;
        String line;

        int t = 1;

        while (!Objects.equals(input = br.readLine(), "")) {
            st = new StringTokenizer(input);

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            board = new int[n];
            count = 0;

            for (int i = 0; i < n; i++) {
                line = br.readLine();

                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == '*') {
                        count++;
                        board[i] |= 1 << j;
                    }
                }
            }

            min = 900;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((board[i] & (1 << j)) == 0) {
                        int[] tmp = board.clone();
                        board[i] |= 1 << j;

                        dfs(0, i, j);
                        board = tmp;
                    }
                }
            }

            sb.append("Case ").append(t++).append(": ").append(min == 900 ? -1 : min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int i, int j) {

        boolean fin = true;

        for (int[] d : D) {
            int[] tmp = board.clone();

            int x = i + d[0], y = j + d[1];

            if (!inRange(x, y)) continue;

            fin = false;

            while (inRange(x, y)) {
                board[x] |= 1 << y;

                x += d[0];
                y += d[1];
            }

            dfs(depth + 1, x - d[0], y - d[1]);

            board = tmp;
        }

        if (fin && isFull()) {
            min = Math.min(min, depth);
        }
    }

    static boolean isFull() {
        for (int i = 0; i < n; i++) {
            if (board[i] < (1 << m) - 1) return false;
        }

        return true;
    }

    static boolean inRange(int x, int y) {
        return x < n && y < m && x >= 0 && y >= 0 && (board[x] & (1 << y)) == 0;
    }
}