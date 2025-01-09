package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전분배_1943 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 3; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            List<Integer> coins = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

                sum += v * c;

                while (c > 0) {
                    int b = 1;

                    while (b <= c) {
                        coins.add(b * v);
                        c -= b;
                        b <<= 1;
                    }
                }
            }

            if (sum % 2 == 1) {
                System.out.println(0);
                continue;
            }

            sum /= 2;

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;

            for (int coin : coins) {
                for (int i = sum; i >= coin; i--) {
                    if (dp[i - coin]) dp[i] = true;
                }
            }

            System.out.println(dp[sum] ? 1 : 0);
        }
    }
}