package BOJ;

import java.io.*;
import java.util.*;

public class 경찰차_2618 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        int[][] incidents1 = new int[w + 1][];
        int[][] incidents2 = new int[w + 1][];

        incidents1[0] = new int[]{1, 1};
        incidents2[0] = new int[]{n, n};

        for (int i = 1; i <= w; i++) {
            incidents1[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            incidents2[i] = incidents1[i];
        }

        int[][] dp = new int[w + 1][w + 1];
        for (int i = 0; i <= w; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        int[][][] routes = new int[w + 1][w + 1][2];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                int l = Math.max(i, j);

                int d1 = Math.abs(incidents1[l + 1][0] - incidents1[i][0]) + Math.abs(incidents1[l + 1][1] - incidents1[i][1]);
                int d2 = Math.abs(incidents2[l + 1][0] - incidents2[j][0]) + Math.abs(incidents2[l + 1][1] - incidents2[j][1]);

                if (dp[l + 1][j] > dp[i][j] + d1) {
                    dp[l + 1][j] = dp[i][j] + d1;
                    routes[l + 1][j][0] = i;
                    routes[l + 1][j][1] = j;
                }

                if (dp[i][l + 1] > dp[i][j] + d2) {
                    dp[i][l + 1] = dp[i][j] + d2;
                    routes[i][l + 1][0] = i;
                    routes[i][l + 1][1] = j;
                }
            }
        }

        int x = 0;
        int y = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < w; i++) {
            if (dp[i][w] < min) {
                min = dp[i][w];
                x = i;
                y = w;
            }

            if (dp[w][i] < min) {
                min = dp[w][i];
                x = w;
                y = i;
            }
        }

        int[] order = new int[w];

        int p = w;

        while (x > 0 || y > 0) {
            if (x == p) {
                order[p-- - 1] = 1;
            } else {
                order[p-- - 1] = 2;
            }

            int nx = routes[x][y][0];
            int ny = routes[x][y][1];
            x = nx;
            y = ny;
        }

        bw.append(String.valueOf(min)).append("\n");

        for (int num : order) {
            bw.append(String.valueOf(num)).append("\n");
        }

        bw.flush();
    }
}