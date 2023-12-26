package SWExpertAcademy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기_1868 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            char[][] board = new char[n][];
            for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

            int dots = 0;
            int[][] mines = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.') {
                        dots++;
                    } else {
                        for (int[] d : D) {
                            int x = i + d[0];
                            int y = j + d[1];

                            if (x < 0 || y < 0 || x >= n || y >= n) continue;

                            mines[x][y]++;
                        }
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();

            int click = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.' && mines[i][j] == 0) {
                        click++;

                        board[i][j] = 'c';

                        q.add(new int[]{i, j});
                        dots--;

                        while (!q.isEmpty()) {
                            int[] now = q.poll();

                            if (mines[now[0]][now[1]] > 0) continue;

                            for (int[] d : D) {
                                int x = now[0] + d[0];
                                int y = now[1] + d[1];

                                if (x < 0 || y < 0 || x >= n || y >= n || board[x][y] != '.') continue;

                                board[x][y] = 'c';

                                q.add(new int[]{x, y});
                                dots--;
                            }
                        }
                    }
                }
            }

            click += dots;

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(click)).append("\n");
        }

        bw.flush();
    }
}