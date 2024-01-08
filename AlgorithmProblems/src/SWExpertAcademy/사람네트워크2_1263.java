package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사람네트워크2_1263 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[][] minDistance = new int[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(minDistance[i], 1000);
                minDistance[i][i] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        minDistance[i][j] = 1;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;

                    for (int k = 1; k <= n; k++) {
                        if (i == k || j == k) continue;

                        minDistance[j][k] = Math.min(minDistance[j][k], minDistance[j][i] + minDistance[i][k]);
                    }
                }
            }

            int min = 1000000;

            for (int i = 1; i <= n; i++) {
                int s = 0;

                for (int j = 1; j <= n; j++) {
                    s += minDistance[i][j];
                }

                min = Math.min(min, s);
            }

            bw.append(String.valueOf(min)).append("\n");
        }

        bw.flush();
    }
}