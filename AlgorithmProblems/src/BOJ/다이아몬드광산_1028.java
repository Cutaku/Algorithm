package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 다이아몬드광산_1028 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];

        int[][] mine = new int[r][];
        for (int i = 0; i < r; i++) mine[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int[][][] max = new int[4][r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                max[0][i][j] += mine[i][j];
                if (mine[i][j] > 0 && i > 0 && j > 0) max[0][i][j] += max[0][i - 1][j - 1];

                max[1][i][j] += mine[i][j];
                if (mine[i][j] > 0 && i > 0 && j < c - 1) max[1][i][j] += max[1][i - 1][j + 1];
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                max[2][i][j] += mine[i][j];
                if (mine[i][j] > 0 && i < r - 1 && j > 0) max[2][i][j] += max[2][i + 1][j - 1];

                max[3][i][j] += mine[i][j];
                if (mine[i][j] > 0 && i < r - 1 && j < c - 1) max[3][i][j] += max[3][i + 1][j + 1];
            }
        }

        int m = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; i + k < r; k += 2) {
                    if (Math.min(max[2][i][j], max[3][i][j]) < k / 2 + 1) break;
                    if (Math.min(max[0][i + k][j], max[1][i + k][j]) >= k / 2 + 1) m = Math.max(m, k / 2 + 1);
                }
            }
        }

        System.out.println(m);
    }
}