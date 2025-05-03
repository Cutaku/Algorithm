package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 습격받은도시_20947 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'O') {
                    q.add(new int[]{i, j});
                } else if (map[i][j] == 'X') {
                    for (int[] d : D) {
                        int r = i + d[0], c = j + d[1];

                        while (r >= 0 && c >= 0 && r < n && c < n && map[r][c] == '.') {
                            map[r][c] = 'B';
                            r += d[0];
                            c += d[1];
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] d : D) {
                int r = p[0] + d[0], c = p[1] + d[1];

                while (r >= 0 && c >= 0 && r < n && c < n && map[r][c] != 'O' && map[r][c] != 'X') {
                    map[r][c] = '.';
                    r += d[0];
                    c += d[1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}