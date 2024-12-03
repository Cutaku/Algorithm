package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoMachines_17528 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] tasks = new int[n][];

        int sumA = 0;
        int sumB = 0;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sumA += a;
            sumB += b;

            tasks[i] = new int[]{a, b};
        }

        int[] dp = new int[sumA + 1];

        for (int i = 0; i < n; i++) {
            for (int j = sumA; j >= tasks[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - tasks[i][0]] + tasks[i][1]);
            }
        }

        int min = 62500;

        for (int i = 0; i <= sumA; i++) {
            min = Math.min(min, Math.max(i, sumB - dp[i]));
        }

        System.out.println(min);
    }
}