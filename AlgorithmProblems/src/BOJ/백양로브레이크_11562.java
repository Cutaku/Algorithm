package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백양로브레이크_11562 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 300);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1, v = Integer.parseInt(st.nextToken()) - 1;

            dist[u][v] = 0;
            dist[v][u] = st.nextToken().charAt(0) == '0' ? 1 : 0;
        }

        for (int d = 0; d < n; d++) {
            for (int i = 0; i < n; i++) {
                if (d == i) continue;

                for (int j = 0; j < n; j++) {
                    if (d == j || i == j) continue;

                    dist[i][j] = Math.min(dist[i][d] + dist[d][j], dist[i][j]);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(dist[s][e]).append("\n");
        }

        System.out.println(sb);
    }
}