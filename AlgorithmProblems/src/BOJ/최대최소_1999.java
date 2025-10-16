package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대최소_1999 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] min = new int[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                min[i][j] = max[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int l = 1; l < b; l++) {
            for (int i = n - 1; i >= l; i--) {
                for (int j = n - 1; j >= l; j--) {
                    min[i][j] = Math.min(min[i][j], min[i][j - 1]);
                    min[i][j] = Math.min(min[i][j], min[i - 1][j]);
                    min[i][j] = Math.min(min[i][j], min[i - 1][j - 1]);

                    max[i][j] = Math.max(max[i][j], max[i][j - 1]);
                    max[i][j] = Math.max(max[i][j], max[i - 1][j]);
                    max[i][j] = Math.max(max[i][j], max[i - 1][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) + b - 2;
            int c = Integer.parseInt(st.nextToken()) + b - 2;

            sb.append(max[r][c] - min[r][c]).append("\n");
        }

        System.out.println(sb);
    }
}