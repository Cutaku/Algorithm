package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 먹이사슬_2532 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[2] == b[2]) return b[1] - a[1];
            return a[2] - b[2];
        });

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());

            set.add(new int[]{m, l, r});
        }

        int[] dp = new int[n + 1];
        dp[0] = Integer.MAX_VALUE;

        int idx = 1;

        while (!set.isEmpty()) {
            int[] poll = set.pollFirst();

            int s = 0, e = idx;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (dp[m] < poll[1]) e = m;
                else s = m;
            }

            dp[e] = Math.max(dp[e], poll[1]);
            if (e == idx) idx++;
        }

        System.out.println(idx - 1);
    }
}