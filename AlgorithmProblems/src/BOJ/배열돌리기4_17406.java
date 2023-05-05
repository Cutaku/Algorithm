package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 배열돌리기4_17406 {
    static int[][] matrix;
    static int[][] copyMatrix;
    static int[][] rotations;
    static boolean[] used;
    static int min;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nmk[0], m = nmk[1], k = nmk[2];

        matrix = new int[n][];
        copyMatrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            copyMatrix[i] = new int[m];
        }

        rotations = new int[k][];
        for (int i = 0; i < k; i++) rotations[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        used = new boolean[k];

        min = 5000;

        dfs(0, k);

        System.out.println(min);
    }

    static void dfs(int d, int k) {

        if (d == k) {
            min = Math.min(min, findValue(copyMatrix));
            return;
        }

        for (int i = 0; i < k; i++) {
            if (d == 0) copy(matrix, copyMatrix);

            if (used[i]) continue;

            used[i] = true;
            rotate(copyMatrix, rotations[i]);
            dfs(d + 1, k);
            used[i] = false;
            reverse(copyMatrix, rotations[i]);
        }
    }

    static void rotate(int[][] matrix, int[] rotation) {

        int r = rotation[0] - 1;
        int c = rotation[1] - 1;
        int s = rotation[2];

        for (int i = 1; i <= s; i++) {
            int temp = matrix[r - i][c - i];

            for (int j = 0; j < 2 * i; j++) matrix[r - i + j][c - i] = matrix[r -i + j + 1][c - i];
            for (int j = 0; j < 2 * i; j++) matrix[r + i][c - i + j] = matrix[r + i][c - i + j + 1];
            for (int j = 0; j < 2 * i; j++) matrix[r + i - j][c + i] = matrix[r + i - j - 1][c + i];
            for (int j = 0; j < 2 * i; j++) matrix[r - i][c + i - j] = matrix[r - i][c + i - j - 1];

            matrix[r - i][c - i + 1] = temp;
        }
    }

    static void reverse(int[][] matrix, int[] rotation) {

        int r = rotation[0] - 1;
        int c = rotation[1] - 1;
        int s = rotation[2];

        for (int i = 1; i <= s; i++) {
            int temp = matrix[r - i][c - i];

            for (int j = 0; j < 2 * i; j++) matrix[r - i][c - i + j] = matrix[r - i][c - i + j + 1];
            for (int j = 0; j < 2 * i; j++) matrix[r - i + j][c + i] = matrix[r - i + j + 1][c + i];
            for (int j = 0; j < 2 * i; j++) matrix[r + i][c + i - j] = matrix[r + i][c + i - j - 1];
            for (int j = 0; j < 2 * i; j++) matrix[r + i - j][c - i] = matrix[r + i - j - 1][c - i];

            matrix[r - i + 1][c - i] = temp;
        }
    }

    static int findValue(int[][] matrix) {

        int min = 5000;

        for (int[] row : matrix) {
            int sum = 0;
            for (int num : row) sum += num;

            min = Math.min(min, sum);
        }

        return min;
    }

    static void copy(int[][] matrix1, int[][] matrix2) {

        int n = matrix1.length;
        int m = matrix1[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = matrix1[i][j];
            }
        }
    }
}