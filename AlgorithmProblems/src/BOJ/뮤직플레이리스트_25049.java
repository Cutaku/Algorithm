package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뮤직플레이리스트_25049 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        long[] dp = new long[n];

        long sum = 0;
        long max = 0;
        long arrSum = arr[n - 1];

        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
            arrSum += arr[i];

            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }

            dp[i] = max;
        }

        sum = 0;
        max = 0;
        long returnMax = 0;

        for (int i = n - 1; i > 0; i--) {
            sum += arr[i];
    
            if (sum < 0) {
                sum = 0;
            } else {
                max = Math.max(max, sum);
            }

            returnMax = Math.max(returnMax, dp[i - 1] + max);
        }

        System.out.println(arrSum + returnMax);
    }
}