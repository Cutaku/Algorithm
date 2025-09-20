package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 과제_13904 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] assignments = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            assignments[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(assignments, Comparator.comparingInt(a -> -a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        int ans = 0;

        for (int d = 1000; d > 0; d--) {
            while (idx < n && assignments[idx][0] >= d) pq.add(assignments[idx++][1]);

            if (!pq.isEmpty()) ans += pq.poll();
        }

        System.out.println(ans);
    }
}