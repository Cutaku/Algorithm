package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 전화번호만들기_1594 {
    static String number;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = br.readLine();
        int l = number.length();

        int[] dp = new int[l];
        String[] ans = new String[l];

        dp[1] = score(0, 2);
        if (l > 2) dp[2] = score(0, 3);
        if (l > 3) dp[3] = score(0, 2) + score(2, 4);

        ans[1] = number.substring(0, 2);
        if (l > 2) ans[2] = number.substring(0, 3);
        if (l > 3) ans[3] = number.substring(0, 2) + "-" + number.substring(2, 4);

        for (int i = 4; i < l; i++) {
            int a = dp[i - 2] + score(i - 1, i + 1);
            int b = dp[i - 3] + score(i - 2, i + 1);

            if (a > b) {
                dp[i] = a;
                ans[i] = ans[i - 2] + "-" + number.substring(i - 1, i + 1);
            } else if (a < b) {
                dp[i] = b;
                ans[i] = ans[i - 3] + "-" + number.substring(i - 2, i + 1);
            } else {
                dp[i] = a;

                String x = ans[i - 2] + "-" + number.substring(i - 1, i + 1);
                String y = ans[i - 3] + "-" + number.substring(i - 2, i + 1);

                if (x.compareTo(y) < 0) ans[i] = x;
                else ans[i] = y;
            }
        }

        System.out.println(ans[l - 1]);
    }

    static int score(int s, int e) {

        Set<Character> set = new HashSet<>();

        for (int i = s; i < e; i++) {
            set.add(number.charAt(i));
        }

        if (set.size() == 1) return 2;
        return e - s - set.size();
    }
}