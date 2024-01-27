package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_14502 {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> safe;
    static int s;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        safe = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) safe.add(new int[]{i, j});
            }
        }

        s = safe.size();

        max = 0;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int d, int i) {
        if (d == 3) {
            max = Math.max(max, count());
            return;
        }

        for (int j = i; j < s + d - 2; j++) {
            int[] p = safe.get(j);

            map[p[0]][p[1]] = 1;

            dfs(d + 1, j + 1);

            map[p[0]][p[1]] = 0;
        }
    }

    static int[][] copy() {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) result[i] = map[i].clone();

        return  result;
    }

    static int count() {
        int[][] cMap = copy();

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cMap[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || cMap[x][y] > 0) continue;

                q.add(new int[]{x, y});
                cMap[x][y] = 2;
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cMap[i][j] == 0) count++;
            }
        }

        return count;
    }
}