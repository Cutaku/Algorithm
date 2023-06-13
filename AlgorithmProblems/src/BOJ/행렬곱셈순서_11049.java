package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 행렬곱셈순서_11049 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] matrices = new int[n][];
        for (int i = 0; i < n; i++) matrices[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[][] ans = new int[n][];
        for (int i = 0; i < n; i++) ans[i] = new int[n];

        for (int k = 1; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                ans[i][i + k] = Integer.MAX_VALUE;

                for (int j = 0; j < k; j++) {
                    ans[i][i + k] = Math.min(ans[i][i + k], ans[i][i + j] + ans[i + j + 1][i + k] + matrices[i][0] * matrices[i + j][1] * matrices[i + k][1]);
                }
            }
        }

        System.out.println(ans[0][n - 1]);
    }
}