package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 험난한등굣길_26009 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[n][m];

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());


            for (int x = r - d; x <= r + d; x++) {
                if (x < 0 || x >= n) continue;

                int a = (d - Math.abs(r - x));

                for (int j = -1; j < 2; j += 2) {
                    int y = c + j * a;

                    if (y < 0 || y >= m) continue;

                    v[x][y] = true;
                }
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0});
        v[0][0] = true;

        int count = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println("YES");
                System.out.println(count);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= m || v[x][y]) continue;

                v[x][y] = true;

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                count++;
            }
        }

        System.out.println("NO");
    }
}