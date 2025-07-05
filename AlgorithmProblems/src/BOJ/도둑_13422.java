package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도둑_13422 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = m; i <= n; i++) {
                if (sum[i] - sum[i - m] < k) cnt++;
            }

            if (m < n) {
                for (int i = 1; i < m; i++) {
                    if (sum[i] - sum[0] + sum[n] - sum[n - m + i] < k) cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}