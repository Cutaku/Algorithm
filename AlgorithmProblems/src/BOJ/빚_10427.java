package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빚_10427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int[][] dif = new int[n][n];

            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    dif[j][i] += dif[j + 1][i] + arr[i] - arr[j];
                }
            }

            long ans = 0;

            for (int d = 1; d < n; d++) {
                int min = Integer.MAX_VALUE;

                for (int i = 0; i + d < n; i++) {
                    min = Math.min(min, dif[i][i + d]);
                }

                ans += min;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}