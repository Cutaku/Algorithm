package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열제거_21941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int m = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            a: for (String word : map.keySet()) {
                int l = word.length();

                if (i - 1 + l > s.length()) continue;

                for (int j = 0; j < l; j++) {
                    if (word.charAt(j) != s.charAt(i - 1 + j)) continue a;
                }

                dp[i + l - 1] = Math.max(dp[i + l - 1], dp[i - 1] + map.get(word));
            }

            dp[i] = Math.max(dp[i], dp[i - 1] + 1);
        }

        System.out.println(dp[s.length()]);
    }
}