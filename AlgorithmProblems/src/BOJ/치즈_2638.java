package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 치즈_2638 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] board = new int[n][];
        for (int i = 0; i < n; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        board[0][0] = 2;

        extendAir(board, q);
        findMeltingCheese(board, q);

        int time = 0;

        while (!q.isEmpty()) {
            time++;
            extendAir(board, q);
            findMeltingCheese(board, q);
        }

        System.out.println(time);
    }

    public static void extendAir(int[][] board, Queue<int[]> q) {

        int n = board.length;
        int m = board[0].length;

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] > 0) continue;

                board[x][y] = 2;

                q.add(new int[]{x, y});
            }
        }
    }

    public static int countAir(int[][] board, int i, int j) {

        int n = board.length;
        int m = board[0].length;

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int count = 0;

        for (int[] d : D) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || y < 0 || x >= n || y >= m) continue;

            if (board[x][y] == 2) count++;
        }

        return count;
    }

    public static void findMeltingCheese(int[][] board, Queue<int[]> q) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && countAir(board, i, j) > 1)  q.add(new int[]{i, j});
            }
        }

        for (int[] point : q) {
            board[point[0]][point[1]] = 2;
        }
    }
}