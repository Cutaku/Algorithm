package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 저울_10159 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] compare = new boolean[n][n];

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            compare[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;

                for (int j = 0; j < n; j++) {
                    if (j == k || j == i) continue;

                    if (compare[i][k] && compare[k][j]) {
                        compare[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (!compare[i][j] && !compare[j][i]) count++;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}