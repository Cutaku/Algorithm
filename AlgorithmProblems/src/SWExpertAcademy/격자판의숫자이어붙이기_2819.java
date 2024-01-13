package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class 격자판의숫자이어붙이기_2819 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[][] board = new int[4][];
            for (int i = 0; i < 4; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Set<Integer> set = new HashSet<>();
            Queue<int[]> q = new ArrayDeque<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    q.add(new int[]{i, j, board[i][j], 1});

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        if (now[3] == 7) {
                            set.add(now[2]);
                            continue;
                        }

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x > 3 || y > 3) continue;

                            q.add(new int[]{x, y, now[2] * 10 + board[x][y], now[3] + 1});
                        }
                    }
                }
            }

            bw.append(String.valueOf(set.size())).append("\n");
        }
        bw.flush();
    }
}