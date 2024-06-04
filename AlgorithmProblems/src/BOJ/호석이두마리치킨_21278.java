package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호석이두마리치킨_21278 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], n);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int b1 = Integer.parseInt(st.nextToken()) - 1;
            int b2 = Integer.parseInt(st.nextToken()) - 1;

            dist[b1][b2] = 1;
            dist[b2][b1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == i || j == k) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] ans = {0, 0, 10000};

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int min = 0;

                for (int k = 0; k < n; k++) {
                    min += Math.min(dist[i][k], dist[j][k]);
                }

                if (min < ans[2]) {
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = min;
                }
            }
        }

        System.out.print(ans[0] + 1);
        System.out.print(" ");
        System.out.print(ans[1] + 1);
        System.out.print(" ");
        System.out.print(ans[2] * 2);
    }
}