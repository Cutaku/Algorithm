package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일채우기_2133 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] tile = new int[n + 1];
        tile[0] = 1;
        if (n > 1) tile[2] = 3;

        for (int i = 4; i < n + 1; i++) {
            tile[i] = tile[i - 2] * 3;

            for (int j = 2; j * 2 <= i; j++) {
                tile[i] += tile[i - j * 2] * 2;
            }
        }

        System.out.println(tile[n]);
    }
}