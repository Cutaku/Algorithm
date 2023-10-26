package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 점프_2253 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int k = 1;

        while (k * (k + 1) < 2 * n) k++;

        int[][] count = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(count[i], 10000);

        for (int i = 0; i < m; i++) {
            count[Integer.parseInt(br.readLine())] = null;
        }

        count[1][0] = 0;

        for (int i = 2; i <= n; i++) {
            if (count[i] == null) continue;

            for (int j = 1; j <= k; j++) {
                if (i < j || count[i - j] == null) continue;

                count[i][j] = Math.min(count[i][j], count[i - j][j - 1] + 1);
                count[i][j] = Math.min(count[i][j], count[i - j][j] + 1);
                if (j < k) count[i][j] = Math.min(count[i][j], count[i - j][j + 1] + 1);
            }
        }

        int min = 10000;

        for (int i = 0; i <= k; i++) {
            min = Math.min(min, count[n][i]);
        }

        if (min == 10000) System.out.println(- 1);
        else System.out.println(min);
    }
}