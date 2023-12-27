package SWExpertAcademy;

import java.io.*;
import java.util.Arrays;

public class 숫자배열회전_1961 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.append("#").append(String.valueOf(t)).append("\n");

            int n = Integer.parseInt(br.readLine());

            int[][] matrix = new int[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int[][][] matrices = new int[3][][];

            matrices[0] = rotate(matrix);
            matrices[1] = rotate(matrices[0]);
            matrices[2] = rotate(matrices[1]);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < n; k++) {
                        bw.append(String.valueOf(matrices[j][i][k]));
                    }

                    bw.append(" ");
                }

                bw.append("\n");
            }
        }

        bw.flush();
    }

    static int[][] rotate(int[][] matrix) {

        int n = matrix.length;

        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[n - 1 - j][i];
            }
        }

        return result;
    }
}