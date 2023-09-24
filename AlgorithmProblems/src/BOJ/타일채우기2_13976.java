package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일채우기2_13976 {
    static int d = 1000000007;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        n /= 2;

        long sum = 0;
        long count = 1;

        long[][] mat = new long[][]{{1, 1}, {2, 3}};

        while (n > 0) {
            if (n % 2 == 0) {
                mat = matSquare(mat);
                n /= 2;
            } else {
                long s = (sum * mat[0][0] + count * mat[0][1]) % d;
                long c = (sum * mat[1][0] + count * mat[1][1]) % d;

                sum = s;
                count = c;

                n--;
            }
        }

        System.out.println(count);
    }

    public static long[][] matSquare(long[][] mat) {

        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += mat[i][k] * mat[k][j];
                    result[i][j] %= d;
                }
            }
        }

        return result;
    }
}