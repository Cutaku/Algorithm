package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 역사_1613 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] early = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            early[v1][v2] = -1;
            early[v2][v1] = 1;
        }

        for (int d = 0; d < n; d++) {
            for (int i = 0; i < n; i++) {
                if (i == d || early[i][d] == 0) continue;

                for (int j = 0; j < n; j++) {
                    if (j == d || j == i || early[d][j] == 0) continue;

                    if (early[i][d] == early[d][j]) early[i][j] = early[i][d];
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());

            sb.append(early[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]).append("\n");
        }

        System.out.println(sb);
    }
}