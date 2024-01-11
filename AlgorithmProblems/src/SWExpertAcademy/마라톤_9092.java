package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 마라톤_9092 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nk[0], k = nk[1];

            int[][] positions = new int[n][];
            for (int i = 0; i < n; i++) positions[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] distances = new int[n][n];
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < Math.min(n, i + k + 2); j++) {
                    distances[i][j] = Math.abs(positions[i][0] - positions[j][0]) + Math.abs(positions[i][1] - positions[j][1]);
                }
            }

            int[][] min = new int[n][k + 1];

            for (int i = 0; i < n; i++) Arrays.fill(min[i], 1000000);
            min[0][0] = 0;

            for (int j = 0; j <= k; j++) {
                for (int i = j + 1; i < n; i++) {
                    for (int l = 0; l <= j; l++) {
                        min[i][j] = Math.min(min[i][j], min[i - l - 1][j - l] + distances[i - l - 1][i]);
                    }
                }
            }

            bw.append(String.valueOf(min[n -1][k])).append("\n");
        }

        bw.flush();
    }
}