package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수3_2749 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long[][] A = new long[][]{{0, 1}, {1, 1}};
        long[][] B = new long[][]{{0}, {1}};

        n--;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;

                A = matMul(A, A);
            } else {
                n--;

                B = matMul(A, B);
            }
        }

        System.out.println(B[1][0]);
    }

    public static long[][] matMul(long[][] A, long[][] B) {

        int n = A.length;
        int m = B.length;
        int o = B[0].length;

        long[][] result = new long[n][o];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < o; j++) {
                for (int k = 0; k < m; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000000;
                }
            }
        }

        return result;
    }
}