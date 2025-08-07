package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 기숙사재배정_10978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[21];
        dp[2] = 1;

        for (int i = 3; i < 21; i++) dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0)  sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

        System.out.println(sb);
    }
}