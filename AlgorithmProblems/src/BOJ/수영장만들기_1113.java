package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영장만들기_1113 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pool = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                pool[i][j] = line.charAt(j) - '0';
            }
        }

        int sum = 0;

        Queue<int[]> q = new ArrayDeque<>();

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int h = 2; h <= 9; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (pool[i][j] >= h) continue;

                    boolean overflow = false;

                    q.add(new int[]{i, j});
                    pool[i][j] = h;

                    int count = 1;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int[] d : D) {
                            int x = now[0] + d[0];
                            int y = now[1] + d[1];

                            if (x < 0 || y < 0 || x >= n || y >= m) {
                                overflow = true;
                                continue;
                            }

                            if (pool[x][y] < h) {
                                q.add(new int[]{x, y});
                                pool[x][y] = h;
                                count++;
                            }
                        }
                    }

                    if (!overflow) sum += count;
                }
            }
        }

        System.out.println(sum);
    }
}