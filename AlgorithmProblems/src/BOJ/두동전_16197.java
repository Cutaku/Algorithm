package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두동전_16197 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];

        int coin1 = 0;
        int coin2 = 0;

        boolean c = false;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '#') {
                    map[i][j] = true;
                } else if (line.charAt(j) == 'o') {
                    if (c) coin1 = 100 * i + j;
                    else coin2 = 100 * i + j;

                    c = true;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        set.add(10000 * coin1 + coin2);
        set.add(10000 * coin2 + coin1);

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(10000 * coin1 + coin2);

        int count = 1;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q1.isEmpty() && count < 11) {
            int now = q1.poll();

            int r1 = now / 1000000;
            now %= 1000000;

            int c1 = now / 10000;
            now %= 10000;

            int r2 = now / 100;
            now %= 100;

            int c2 = now;

            for (int[] d : D) {
                int x1 = r1 + d[0], y1 = c1 + d[1];
                int x2 = r2 + d[0], y2 = c2 + d[1];

                boolean b1 = x1 < 0 || y1 < 0 || x1 >= n || y1 >= m;
                boolean b2 = x2 < 0 || y2 < 0 || x2 >= n || y2 >= m;

                if (b1 && b2) {
                    continue;
                }

                if (b1 || b2) {
                    System.out.println(count);
                    return;
                }

                if (map[x1][y1]) {
                    x1 = r1;
                    y1 = c1;
                }

                if (map[x2][y2]) {
                    x2 = r2;
                    y2 = c2;
                }

                if (x1 == x2 && y1 == y2) continue;

                int coins = 1000000 * x1 + 10000 * y1 + 100 * x2 + y2;

                if (set.contains(coins)) continue;

                set.add(coins);
                set.add(1000000 * x2 + 10000 * y2 + 100 * x1 + y1);

                q2.add(coins);
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                count++;
            }
        }

        System.out.println(-1);
    }
}