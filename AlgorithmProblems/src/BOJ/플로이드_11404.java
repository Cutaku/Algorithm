package BOJ;

import java.io.*;
import java.util.Arrays;

public class 플로이드_11404 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] minDistances = new int[n][n];
        for (int i = 0; i < n; i++)  Arrays.fill(minDistances[i], 10000000);

        for (int i = 0; i < m; i++) {
            int[] bus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            minDistances[bus[0] - 1][bus[1] - 1] = Math.min(minDistances[bus[0] - 1][bus[1] - 1], bus[2]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k || i == j) continue;

                    minDistances[j][k] = Math.min(minDistances[j][k], minDistances[j][i] + minDistances[i][k]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            minDistances[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (minDistances[i][j] == 10000000) bw.append(0 + " ");
                else bw.append(minDistances[i][j] + " ");
            }

            bw.append("\n");
        }

        bw.flush();
    }
}