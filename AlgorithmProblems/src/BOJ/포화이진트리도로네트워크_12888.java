package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포화이진트리도로네트워크_12888 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(br.readLine());

        if (h == 0) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[h + 1];
        dp[0] = 1;

        for (int i = 1; i <= h; i++) {
            dp[i] = 2 * dp[i - 1] + (i % 2 == 0 ? 1 : 0);
        }

        System.out.println(dp[h] - dp[h - 1]);
    }
}