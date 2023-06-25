package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약_10026 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] picture = new char[n][];
        for (int i = 0; i < n; i++) picture[i] = br.readLine().toCharArray();

        System.out.print(countSector(picture, false) + " ");
        System.out.println(countSector(picture, true));
    }

    public static int countSector(char[][] board, boolean isColorBlind) {

        int n = board.length;

        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] checked = new boolean[n][n];

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j]) continue;

                checked[i][j] = true;

                char color = board[i][j];

                q.add(new int[]{i, j});

                count++;

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= n || checked[x][y]) continue;

                        if (isSameColor(color, board[x][y], isColorBlind)) {
                            checked[x][y] = true;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return count;
    }

    public static boolean isSameColor(char color1, char color2, boolean isColorBlind) {

        if (isColorBlind) {
            if (color1 == 'B') return color2 == 'B';
            else return (color2 == 'R' || color2 == 'G');
        } else {
            return color1 == color2;
        }
    }
}