package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 도넛행성_27211 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        boolean[][] v = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                v[i][j] = st.nextToken().charAt(0) == '1';
            }
        }

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    ans++;

                    q1.add(new int[]{i, j});
                    v[i][j] = true;

                    while (!q1.isEmpty()) {
                        int[] now = q1.poll();

                        for (int[] d : D) {
                            int x = (now[0] + d[0] + n) % n;
                            int y = (now[1] + d[1] + m) % m;

                            if (v[x][y]) continue;

                            q2.add(new int[]{x, y});
                            v[x][y] = true;
                        }

                        if (q1.isEmpty()) {
                            Queue<int[]> tmp = q1;
                            q1 = q2;
                            q2 = tmp;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}