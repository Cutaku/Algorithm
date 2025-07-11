package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아름다운행렬_2829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        int[][] d1 = new int[2 * n - 1][n + 1];
        int[][] d2 = new int[2 * n - 1][n + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());

                d1[i - j + n - 1][i + 1] = d1[i - j + n - 1][i] + a;
                d2[i + j][i + 1] = d2[i + j][i] + a;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int s = 0; s < n; s++) {
            for (int i = 0; i + s < n; i++) {
                for (int j = 0; j + s < n; j++) {
                    max = Math.max(max, d1[i - j + n - 1][i + s + 1] - d1[i - j + n - 1][i]
                            - d2[i + j + s][i + s + 1] + d2[i + j + s][i]);
                }
            }
        }

        System.out.println(max);
    }
}