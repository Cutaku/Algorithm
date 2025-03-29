package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 주간미팅_12834 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int[] home = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) home[i] = Integer.parseInt(st.nextToken()) - 1;

        List<int[]>[] adj = new List[v];
        for (int i = 0; i < v; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            adj[c1].add(new int[]{c2, l});
            adj[c2].add(new int[]{c1, l});
        }

        int ans = 0;

        a: for (int i = 0; i < n; i++) {
            int s = home[i];

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[1]));

            int[] min = new int[v];
            Arrays.fill(min, 100000);

            pq.add(new int[]{s, 0});
            min[s] = 0;

            int left = 2;

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (min[now[0]] < now[1]) continue;

                min[now[0]] = now[1];

                if (now[0] == a || now[0] == b) {
                    ans += now[1];
                    left--;

                    if (left == 0) continue a;
                }

                for (int[] next : adj[now[0]]) {
                    if (min[next[0]] > now[1] + next[1]) {
                        min[next[0]] = now[1] + next[1];
                        pq.add(new int[]{next[0], now[1] + next[1]});
                    }
                }
            }

            ans -= left;
        }

        System.out.println(ans);
    }
}