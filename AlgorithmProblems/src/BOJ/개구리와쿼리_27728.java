package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개구리와쿼리_27728 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                map[i][j - 1] += map[i][j];
            }
        }

        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) min[0][i] = map[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min[i][j] = Math.min(map[i][j], min[i - 1][j]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            int m = map[x][y];
            int d = 0;

            for (int j = y; j < n; j++) {
                d = Math.max(d, map[x][j] - min[x - l][j]);
            }

            sb.append(m - d).append("\n");
        }

        System.out.println(sb);
    }
}