package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 치즈_2638 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = hw[0], w = hw[1];

        int[][] board = new int[h][];
        for (int i = 0; i < h; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] expose = new int[h][w];

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(0);
        board[0][0] = 2;

        int count = -1;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q1.isEmpty()) {
            int n = q1.poll();
            int r = n / w;
            int c = n % w;

            for (int[] d : D) {
                int x = r + d[0];
                int y = c + d[1];
                int m = x * w + y;

                if (x < 0 || y < 0 || x >= h || y >= w || board[x][y] == 2) continue;

                if (board[x][y] == 0) {
                    q1.add(m);
                    board[x][y] = 2;
                } else if (board[x][y] == 1 && ++expose[x][y] > 1) {
                    q2.add(m);
                    board[x][y] = 2;
                }
            }

            if (q1.isEmpty()) {
                Queue<Integer> t = q1;
                q1 = q2;
                q2 = t;

                count++;
            }
        }

        System.out.println(count);
    }
}