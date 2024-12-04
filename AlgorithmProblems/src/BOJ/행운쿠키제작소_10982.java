package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행운쿠키제작소_10982 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] doughs = new int[n][];

            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sumA += a;
                sumB += b;

                doughs[i] = new int[]{a, b};
            }

            int[] dp = new int[sumA + 1];

            for (int i = 0; i < n; i++) {
                for (int j = sumA; j >= doughs[i][0]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - doughs[i][0]] + doughs[i][1]);
                }
            }

            int min = 100001;

            for (int i = 0; i <= sumA; i++) {
                min = Math.min(min, Math.max(i, sumB - dp[i]));
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}