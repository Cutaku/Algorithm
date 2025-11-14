package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼사오육칠팔구찾기_12105 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String p = br.readLine();
        String s = br.readLine();

        int[] dp = new int[2521];
        dp[2520] = 1;

        int d = 1000000007;

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (!check(p, s, i)) continue;

            for (int j = 1; j < 2521; j++) {
                int g = gcd(i + 1, j);

                dp[j / g] = (dp[j / g] + dp[j]) % d;
            }
        }

        System.out.println(dp[1]);
    }

    static boolean check(String p, String s, int idx) {

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != s.charAt(idx + i)) return false;
        }

        return true;
    }

    static int gcd(int a, int b) {

        return b == 0 ? a : gcd(b, a % b);
    }
}