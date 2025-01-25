package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 수열_Hard_23828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<Integer, Long> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());

            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1L);
        }

        long[] arr = new long[map.size()];

        int idx = 0;
        for (int key : map.keySet()) {
            arr[idx++] = key * map.get(key);
        }

        long[][] dp = new long[m + 1][idx];

        Arrays.fill(dp[0], 1);
        dp[1][0] = arr[0];

        long d = 1000000007;

        for (int i = 1; i < idx; i++) {
            for (int j = 1; j <= Math.min(i + 1, m); j++) {
                dp[j][i] = (dp[j - 1][i - 1] * arr[i] % d + dp[j][i - 1]) % d;
            }
        }

        System.out.println(dp[m][idx - 1]);
    }
}