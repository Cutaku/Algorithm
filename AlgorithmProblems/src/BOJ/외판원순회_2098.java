package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 외판원순회_2098 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = 1 << n;

        int[][] W = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] min = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        min[1][0] = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (min[i][j] < Integer.MAX_VALUE) {
                    int able = (m - 1) & ~i;

                    int q = 0;

                    while (able > 0) {
                        int p = able & -able;
                        able -= p;

                        while (p > (1 << q)) q++;

                        if (W[j][q] == 0) continue;

                        min[i | p][q] = Math.min(min[i | p][q], min[i][j] + W[j][q]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (min[m - 1][i] < Integer.MAX_VALUE && W[i][0] > 0) {
                ans = Math.min(ans, min[m - 1][i] + W[i][0]);
            }
        }

        System.out.println(ans);
    }
}