package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이의멱수의합_2410 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int d = 1000000000;

        int[][] count = new int[n + 1][21];
        Arrays.fill(count[0], 1);
        for (int i = 0; i <= n; i++) count[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 21; j++) {
                count[i][j] += count[i][j - 1];
                count[i][j] %= d;

                int m = (int) Math.pow(2, j);

                if (i >= m) {
                    count[i][j] += count[i - m][j];
                    count[i][j] %= d;
                }
            }
        }

        System.out.println(count[n][20]);
    }
}