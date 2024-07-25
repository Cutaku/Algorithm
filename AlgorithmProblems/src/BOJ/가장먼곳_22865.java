package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장먼곳_22865 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] min = new int[n][n];
        int[][] next = new int[n][n];

        for (int i = 0; i < n; i++) Arrays.fill(min[i], 200000);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            if (min[v1][v2] > w) {
                min[v1][v2] = w;
                min[v2][v1] = w;
                next[v1][v2] = v2;
                next[v2][v1] = v1;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (k == i) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k || j == i) continue;

                    if (min[i][j] > min[i][k] + min[k][j]) {
                        min[i][j] = min[i][k] + min[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(next[i][j] + 1).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}