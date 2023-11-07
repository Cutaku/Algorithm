package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 자두나무_2240 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = tw[0], w = tw[1];

        int[][] count = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            int p = Integer.parseInt(br.readLine());

            count[i][0] += count[i - 1][0];

            if (p == 1) count[i][0]++;

            for (int j = 1; j <= w; j++) {
                count[i][j] = Math.max(count[i - 1][j - 1], count[i - 1][j]);

                if (i >= j && j % 2 != p % 2) count[i][j]++;
            }
        }

        int max = 0;

        for (int i = 0; i <= w; i++) {
            max = Math.max(max, count[t][i]);
        }

        System.out.println(max);
    }
}