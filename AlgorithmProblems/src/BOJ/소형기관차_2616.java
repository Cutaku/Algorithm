package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소형기관차_2616 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] train = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) train[i] = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[] sum = new int[n];

        for (int i = 0; i < k; i++) {
            sum[k - 1] += train[i];
        }

        for (int i = k; i < n; i++) {
            sum[i] = sum[i - 1] + train[i] - train[i - k];
        }

        int[] dp1 = new int[n];
        dp1[k - 1] = sum[k - 1];

        for (int i = k; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1], sum[i]);
        }

        int[] dp2 = new int[n];
        dp2[2 * k - 1] = sum[k - 1] + sum[2 * k - 1];

        for (int i = 2 * k; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp1[i - k] + sum[i]);
        }

        int[] dp3 = new int[n];
        dp3[3 * k - 1] = sum[k - 1] + sum[2 * k - 1] + sum[3 * k - 1];

        for (int i = 3 * k; i < n; i++) {
            dp3[i] = Math.max(dp3[i - 1], dp2[i - k] + sum[i]);
        }

        System.out.println(dp3[n - 1]);
    }
}