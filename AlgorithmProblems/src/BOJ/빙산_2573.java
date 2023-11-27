package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 빙산_2573 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];

        int[][] sea = new int[n][];
        for (int i = 0; i < n; i++) sea[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;

        do {
            count++;
            sea = melt(sea);
        } while (isSplit(sea) == 1);

        if (isSplit(sea) == 2) System.out.println(count);
        else System.out.println(0);
    }

    public static int[][] melt(int[][] sea) {

        int n = sea.length;
        int m = sea[0].length;

        int[][] temp = new int[n][m];

        int[][] D = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sea[i][j] == 0) continue;

                int c = sea[i][j];

                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= m) continue;

                    if (sea[x][y] == 0) c--;
                }

                temp[i][j] = Math.max(0, c);
            }
        }

        return temp;
    }

    public static int isSplit(int[][] sea) {

        int n = sea.length;
        int m = sea[0].length;

        int count = 0;

        boolean[][] v = new boolean[n][m];

        int[][] D = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] || sea[i][j] == 0) continue;

                count++;

                if (count > 1) return 2;

                v[i][j] = true;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int[] d : D) {
                        int x = now[0] + d[0];
                        int y = now[1] + d[1];

                        if (x < 0 || y < 0 || x >= n || y >= m || v[x][y] || sea[x][y] == 0) continue;

                        v[x][y] = true;

                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        return count;
    }
}