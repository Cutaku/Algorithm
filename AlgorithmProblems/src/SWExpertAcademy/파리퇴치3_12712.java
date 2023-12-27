package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 파리퇴치3_12712 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1] - 1;

            int[][] flies = new int[n][];
            for (int i = 0; i < n; i++) {
                flies[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = -1 * flies[i][j];

                    for (int k = Math.max(0, i - m); k <= Math.min(n - 1, i + m); k++) {
                        sum += flies[k][j];
                    }

                    for (int k = Math.max(0, j - m); k <= Math.min(n - 1, j + m); k++) {
                        sum += flies[i][k];
                    }

                    max = Math.max(max, sum);

                    sum = -1 * flies[i][j];

                    for (int k = -1 * m; k <= m; k++) {
                        if (i + k < 0 || j + k < 0 || i + k >= n || j + k >= n) continue;

                        sum += flies[i + k][j + k];
                    }

                    for (int k = -1 * m; k <= m; k++) {
                        if (i + k < 0 || j - k < 0 || i + k >= n || j - k >= n) continue;

                        sum += flies[i + k][j - k];
                    }

                    max = Math.max(max, sum);
                }
            }

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(max)).append("\n");
        }

        bw.flush();
    }
}