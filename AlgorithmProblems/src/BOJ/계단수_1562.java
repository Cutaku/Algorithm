package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단수_1562 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 1000000000;

        int[][] count = new int[10][];
        for (int i = 0; i < 10; i++) count[i] = new int[1024];

        for (int i = 1; i < 10; i++) count[i][(int) Math.pow(2, i)] = 1;

        for (int t = 1; t < n; t++) {
            int[][] temp = new int[10][];
            for (int i = 0; i < 10; i++) temp[i] = new int[1024];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 1024; j++) {
                    if (i > 0) {
                        if (used(j, i - 1)) {
                            temp[i - 1][j] += count[i][j];
                            temp[i - 1][j] %= d;
                        } else {
                            temp[i - 1][j + (int) Math.pow(2, i - 1)] += count[i][j];
                            temp[i - 1][j + (int) Math.pow(2, i - 1)] %= d;
                        }
                    }

                    if (i < 9) {
                        if (used(j, i + 1)) {
                            temp[i + 1][j] += count[i][j];
                            temp[i + 1][j] %= d;
                        } else {
                            temp[i + 1][j + (int) Math.pow(2, i + 1)] += count[i][j];
                            temp[i + 1][j + (int) Math.pow(2, i + 1)] %= d;
                        }
                    }
                }
            }

            count = temp;
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += count[i][1023];
            sum %= d;
        }

        System.out.println(sum);
    }

    public static boolean used(int n, int m) {

        for (int i = 0; i < m; i++) n /= 2;

        return n % 2 == 1;
    }
}