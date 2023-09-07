package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 색상환 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] count = new int[n + 1][k + 1];

        for (int i = 2; i <= n; i++) count[i][1] = i;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                count[i][j] += count[i - 1][j] + count[i - 2][j - 1];
                count[i][j] %= 1000000003;
            }
        }

        System.out.println(count[n][k]);
    }
}