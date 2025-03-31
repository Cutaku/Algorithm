package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ContestSetting_16688 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());

            map.put(level, map.getOrDefault(level, 0) + 1);
        }

        int s = map.size();
        long d = 998244353;

        long[][] dp = new long[k + 1][s + 1];
        Arrays.fill(dp[0], 1);

        int i = 1;
        for (int v : map.values()) {
            for (int j = 1; j <= k; j++) {
                dp[j][i] = (dp[j][i] + dp[j][i - 1] + dp[j - 1][i - 1] * v) % d;
            }

            i++;
        }

        System.out.println(dp[k][s]);
    }
}