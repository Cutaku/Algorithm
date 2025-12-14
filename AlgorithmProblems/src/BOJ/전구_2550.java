package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 전구_2550 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            seq[arr[i] - 1] = i;
        }

        int[] dp = new int[n];
        int[] before = new int[n];

        int max = 0;
        int mIdx = -1;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());
            int p = seq[b - 1];

            int m = 0;
            int idx = -1;

            for (int j = 0; j < p; j++) {
                if (m < dp[j]) {
                    m = dp[j];
                    idx = j;
                }
            }

            dp[p] = m + 1;
            before[p] = idx;

            if (max < dp[p]) {
                max = dp[p];
                mIdx = p;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        int[] ans = new int[max];

        for (int i = 0; i < max; i++) {
            ans[i] = arr[mIdx];
            mIdx = before[mIdx];
        }

        Arrays.sort(ans);

        for (int i = 0; i < max; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}