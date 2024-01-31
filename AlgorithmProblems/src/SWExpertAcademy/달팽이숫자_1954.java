package SWExpertAcademy;

import java.io.*;

public class 달팽이숫자_1954 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append(String.format("#%d\n", tc));

            int n = Integer.parseInt(br.readLine());

            int[][] snail = new int[n][n];

            int x = 0, y = 0;
            int dx = 0, dy = 1;

            for (int i = 1; i <= n * n; i++) {
                snail[x][y] = i;

                int nx = x + dx, ny = y + dy;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || snail[nx][ny] > 0) {
                    int t = dx;
                    dx = dy;
                    dy = -t;
                }

                x += dx;
                y += dy;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.append(String.format("%d ", snail[i][j]));
                }

                bw.append("\n");
            }
        }

        bw.flush();
    }
}