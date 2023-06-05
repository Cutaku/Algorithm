package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 본대산책2_12850 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long d = Long.parseLong(br.readLine());

        long[][] campus = new long[][]{
                {0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0},
        };

        long[] count = new long[]{1, 0, 0, 0, 0, 0, 0, 0};

        while (d > 0) {
            if (d % 2 == 0) {
                campus = matMul(campus, campus);
                d /= 2;
            } else {
                count = matMulArr(campus, count);
                d--;
            }
        }

        System.out.println(count[0]);
    }

    public static long[][] matMul(long[][] A, long[][] B) {

        long[][] result = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000000007;
                }
            }
        }

        return result;
    }

    public static long[] matMulArr(long[][] A, long[] B) {

        long[] result = new long[8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result[i] += A[i][j] * B[j];
                result[i] %= 1000000007;
            }
        }

        return result;
    }
}