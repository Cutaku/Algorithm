package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파이프옮기기1_17070 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] home = new int[n][];
        for (int i = 0; i < n; i++) home[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] hori = new int[n][];
        int[][] vert = new int[n][];
        int[][] diag = new int[n][];

        for (int i = 0; i < n; i++) {
            hori[i] = new int[n];
            vert[i] = new int[n];
            diag[i] = new int[n];
        }

        hori[0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (home[i][j] == 0) {
                    if (j > 0) hori[i][j] += hori[i][j - 1] + diag[i][j - 1];
                    if (i > 0) vert[i][j] += vert[i - 1][j] + diag[i - 1][j];
                    if (i > 0 && j > 0 && home[i - 1][j] == 0 && home[i][j - 1] == 0) diag[i][j] += hori[i - 1][j - 1] + vert[i - 1][j - 1] + diag[i - 1][j - 1];
                }
            }
        }

        System.out.println(hori[n - 1][n - 1] + vert[n - 1][n - 1] + diag[n - 1][n - 1]);
    }
}