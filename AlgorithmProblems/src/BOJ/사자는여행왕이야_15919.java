package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 사자는여행왕이야_15919 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            for (int i = poll[1]; i <= n; i++) {
                dp[i] = Math.min(dp[i], Math.max(dp[poll[0] - 1], i - poll[1]));
            }
        }

        System.out.println(dp[n]);
    }
}