package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 생일_2995 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] intervals = new int[n + 1][];
        intervals[0] = new int[]{0, 0};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            intervals[i] = new int[]{a, b};
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int[] dp = new int[n + 1];
        int[] before = new int[n + 1];

        int idx = 1;

        for (int i = 1; i <= n; i++) {
            int[] interval = intervals[i];

            int s = 0, e = idx;

            while (e - s > 1) {
                int m = (s + e) >> 1;

                if (intervals[dp[m]][0] < interval[0]) e = m;
                else s = m;
            }

            if (intervals[dp[e]][0] < interval[0]) {
                dp[e] = i;
                before[i] = dp[s];
            }

            if (e == idx) idx++;

        }

        sb.append(idx - 1).append("\n");

        int p = dp[idx - 1];

        while (p > 0) {
            int[] interval = intervals[p];

            sb.append(interval[0]).append(" ").append(interval[1]).append("\n");

            p = before[p];
        }

        System.out.println(sb);
    }
}