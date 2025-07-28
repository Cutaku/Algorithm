package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 같은탑_1126 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = 250001;

        int[] dp = new int[m];
        for (int i = 1; i < m; i++) dp[i] = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (h >= m) continue;

            int[] tmp = new int[m];
            tmp[h] = h;

            for (int j = 0; j < m; j++) {
                if (dp[j] > -1) {
                    if (j + h < m) tmp[j + h] = Math.max(tmp[j + h], dp[j] + h);

                    if (j > h) tmp[j - h] = Math.max(tmp[j - h], dp[j]);
                    else tmp[h - j] = Math.max(tmp[h - j], dp[j] - j + h);
                }
            }

            for (int j = 0; j < m; j++) {
                if (tmp[j] > 0) dp[j] = Math.max(dp[j], tmp[j]);
            }
        }

        System.out.println(dp[0] == 0 ? -1 : dp[0]);
    }
}