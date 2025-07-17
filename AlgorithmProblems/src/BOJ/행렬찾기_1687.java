package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬찾기_1687 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] sum = new int[n][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + line.charAt(j - 1) - '0';
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                int c = 0;
                int max = 0;

                for (int k = 0; k < n; k++) {
                    if (sum[k][i] - sum[k][j] == 0) max = Math.max(max, ++c);
                    else c = 0;
                }

                ans = Math.max(ans, (j - i) * max);
            }
        }

        System.out.println(ans);
    }
}