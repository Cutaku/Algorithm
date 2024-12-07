package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ignition_13141 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][];
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 50000);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1, e = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            edges[i] = new int[]{s, e, l};

            dist[s][e] = Math.min(dist[s][e], l);
            dist[e][s] = dist[s][e];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (i == j || j == k) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    dist[j][i] = dist[i][j];
                }
            }
        }

        int min = 50000;

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < m; j++) {
                int[] edge = edges[j];

                max = Math.max(max, dist[i][edge[0]] + dist[i][edge[1]] + edge[2]);
            }

            min = Math.min(min, max);
        }

        System.out.println(min / 2 + (min % 2 == 0 ? ".0" : ".5"));
    }
}