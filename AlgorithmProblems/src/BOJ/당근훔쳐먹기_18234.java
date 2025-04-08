package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 당근훔쳐먹기_18234 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[1]));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int[] poll = pq.poll();
            ans += poll[0] + (t - i) * poll[1];
        }

        System.out.println(ans);
    }
}