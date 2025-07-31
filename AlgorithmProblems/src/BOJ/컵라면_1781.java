package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 컵라면_1781 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] problems = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            problems[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(problems, Comparator.comparingInt(a -> -a[0]));

        int t = problems[0][0];
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ans = 0;

        while (t > 0) {
            while (idx < n && t == problems[idx][0]) {
                pq.add(problems[idx++][1]);
            }

            if (!pq.isEmpty()) ans += pq.poll();
            t--;
        }

        System.out.println(ans);
    }
}