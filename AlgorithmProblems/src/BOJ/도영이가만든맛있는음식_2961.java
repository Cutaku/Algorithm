package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 도영이가만든맛있는음식_2961 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] ingredients = new int[n][];
        for (int i = 0; i < n; i++) {
            ingredients[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int min = 1000000000;

        for (int i = 1; i < 1 << n; i++) {
            int bit = i;

            int s = 1;
            int b = 0;

            for (int j = 0; j < n; j++) {
                if (bit % 2 != 0) {
                    s *= ingredients[j][0];
                    b += ingredients[j][1];
                }

                bit /= 2;
            }

            min = Math.min(min, Math.abs(s - b));
        }

        System.out.println(min);
    }
}