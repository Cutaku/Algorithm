package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또_2758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T =  Integer.parseInt(br.readLine());

        long[][] dp = new long[11][2001];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 2001; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }
}