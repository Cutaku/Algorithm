package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] min = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], 100);
            min[i][i] = 0;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken()) - 1, v2 = Integer.parseInt(st.nextToken()) - 1;

            min[v1][v2] = 1;
            min[v2][v1] = 1;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == j) continue;

                for (int k = j + 1; k < n; k++) {
                    if (i == k) continue;

                    min[j][k] = Math.min(min[j][k], min[j][i] + min[i][k]);
                    min[k][j] = min[j][k];
                }
            }
        }

        int minIdx = 0;
        int minValue = 10000;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += min[i][j];
            }

            if (sum < minValue) {
                minIdx = i;
                minValue = sum;
            }
        }

        System.out.println(minIdx + 1);
    }
}