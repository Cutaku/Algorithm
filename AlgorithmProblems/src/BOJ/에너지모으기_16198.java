package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에너지모으기_16198 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] max = new int[n + 1][n + 1];

        for (int d = 2; d < n; d++) {
            for (int i = 1; i + d <= n; i++) {
                for (int j = 1; j < d; j++) {
                    max[i][i + d] = Math.max(max[i][i + d], max[i][i + j] + max[i + j][i + d]);
                }

                max[i][i + d] += arr[i] * arr[i + d];
            }
        }

        System.out.println(max[1][n]);
    }
}