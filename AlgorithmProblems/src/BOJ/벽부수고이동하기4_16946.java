package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기4_16946 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int num = 2;

        Map<Integer, Integer> count = new HashMap<>();
        count.put(1, 0);

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (map[r][c] > 0) continue;

            if (map[r][c] == 0) q.add(i);

            map[r][c] = num;

            int s = 1;

            while (!q.isEmpty()) {
                int now = q.poll();

                int x = now / m;
                int y = now % m;

                for (int[] d : D) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] > 0) continue;

                    q.add(nx * m + ny);

                    s++;

                    map[nx][ny] = num;
                }
            }

            count.put(num++, s);
        }

        int[][] ans = new int[n][m];

        Set<Integer> check = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 1) continue;

                check.clear();;

                ans[i][j]++;

                for (int[] d : D) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= m || !check.add(map[x][y])) continue;

                    ans[i][j] += count.get(map[x][y]);
                    ans[i][j] %= 10;
                }
            }
        }

        for (int[] line : ans) {
            for (int l : line) {
                sb.append(l);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}