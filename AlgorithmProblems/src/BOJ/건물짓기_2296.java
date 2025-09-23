package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 건물짓기_2296 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] buildings = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            buildings[i] = new int[]{Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(buildings, Comparator.comparingInt(a -> a[0]));

        int[][] dp = new int[n][2];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = buildings[i][2];

            for (int j = 0; j < i; j++) {
                if (buildings[j][1] < buildings[i][1]) dp[i][0] = Math.max(dp[i][0], dp[j][0] + buildings[i][2]);
                else dp[i][1] = Math.max(dp[i][1], dp[j][1] + buildings[i][2]);
            }

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}