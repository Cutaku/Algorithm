package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 칙령_12875 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int inf = 100000;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);

                if (i == j) dist[i][j] = 0;
                else if (c == 'Y') dist[i][j] = 1;
                else if (c == 'N') dist[i][j] = inf;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k || j == i) continue;

                    if (dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        System.out.println(max == inf ? -1 : max * d);
    }
}