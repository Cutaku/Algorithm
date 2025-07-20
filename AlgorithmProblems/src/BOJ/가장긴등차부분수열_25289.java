package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴등차부분수열_25289 {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] reverse = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            reverse[n - i - 1] = arr[i];
        }

        System.out.println(Math.max(longest(arr), longest(reverse)));
    }

    static int longest(int[] arr) {

        int[][] dp = new int[101][101];
        int res = 0;

        for (int i = 0; i < n; i++) {
            int a = arr[i];

            for (int j = 0; j < 101; j++) {
                dp[a][j] = Math.max(dp[a][j], j <= a ? dp[a - j][j] + 1 : 1);
                res = Math.max(res, dp[a][j]);
            }
        }

        return res;
    }
}