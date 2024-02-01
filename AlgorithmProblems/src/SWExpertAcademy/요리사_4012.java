package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 요리사_4012 {
    static int[][] board;
    static int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            board = new int[4][];
            for (int i = 0; i < 4; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            set = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(board[i][j], i, j, 1);
                }
            }

            bw.append(String.format("#%d %d\n", tc, set.size()));
        }

        bw.flush();
    }

    static void dfs(int n, int i, int j, int c) {
        if (c == 7) {
            set.add(n);
            return;
        }

        for (int[] d : D) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || y < 0 || x > 3 || y > 3) continue;

            dfs(n * 10 + board[x][y], x, y, c + 1);
        }
    }
}