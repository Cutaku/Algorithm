package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박물관견학_30405 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][];
        int total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int[] a = new int[2];
            int[] b = new int[2];

            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            b[0] = Integer.parseInt(st.nextToken());
            b[1] = Integer.parseInt(st.nextToken());

            if (a[0] > b[0]) {
                int[] tmp = a;
                a = b;
                b = tmp;
            }

            k -= a[0];
            total += a[1];

            b[0] -= a[0];
            b[1] -= a[1];

            arr[i] = b;
        }

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
            }
        }

        System.out.println(dp[k] + total);
    }
}