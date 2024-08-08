package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BessiesWeightProblem_5995 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        boolean[] dp = new boolean[h + 1];

        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(br.readLine());

            for (int j = h; j > w; j--) {
                if (dp[j - w]) dp[j] = true;
            }

            dp[w] = true;
        }

        for (int i = h; i > 0; i--) {
            if (dp[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}