package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 색종이와공예_26598 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        char[][] paper = new char[n][];
        for (int i = 0; i < n; i++) paper[i] = br.readLine().toCharArray();

        boolean[][] v = new boolean[n][m];

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j]) continue;

                List<int[]> list = new ArrayList<>();

                list.add(new int[]{i, j});
                v[i][j] = true;
                int idx = 0;

                int minX = i, maxX = i;
                int minY = j, maxY = j;

                while (idx < list.size()) {
                    int[] now = list.get(idx++);

                    for (int[] d : D) {
                        int x = now[0] + d[0], y = now[1] + d[1];

                        if (x < 0 || x >= n || y < 0 || y >= m || v[x][y] || paper[i][j] != paper[x][y]) continue;

                        minX = Math.min(minX, x);
                        maxX = Math.max(maxX, x);
                        minY = Math.min(minY, y);
                        maxY = Math.max(maxY, y);

                        v[x][y] = true;
                        list.add(new int[]{x, y});
                    }
                }

                if ((maxX - minX + 1) * (maxY - minY + 1) > list.size()) {
                    System.out.println("BaboBabo");
                    return;
                }
            }
        }

        System.out.println("dd");
    }
}