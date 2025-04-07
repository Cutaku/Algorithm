package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 합리적인이동경로_2176 {
    static List<int[]>[] adj;
    static int[] min;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        min = new int[n];
        Arrays.fill(min, 100000000);
        min[1] = 0;

        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == 0) break;

            if (now[1] > min[now[0]]) continue;

            for (int[] next : adj[now[0]]) {
                if (now[1] + next[1] < min[next[0]]) {
                    min[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], now[1] + next[1]});
                }
            }
        }

        memo = new int[n];
        Arrays.fill(memo, -1);

        System.out.println(count(1));
    }

    static int count(int i) {

        if (memo[i] != -1) return memo[i];

        int res = i == 0 ? 1 : 0;

        for (int[] next : adj[i]) {
            if (min[i] < min[next[0]]) {
                res += count(next[0]);
            }
        }

        return memo[i] = res;
    }
}