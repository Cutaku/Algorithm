package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아침산책_21606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] inside = new boolean[n];

        String input = br.readLine();
        for (int i = 0; i < n; i++) inside[i] = input.charAt(i) == '1';

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        long ans = 0;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (inside[x] && inside[y]) {
                ans += 2;
            } else {
                adj[y].add(x);
                adj[x].add(y);
            }
        }

        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (inside[i] || v[i]) continue;

            long cnt = 0;
            Queue<Integer> q = new ArrayDeque<>();

            q.add(i);
            v[i] = true;

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : adj[now]) {
                    if (inside[next]) cnt++;
                    else if (!v[next]) {
                        q.add(next);
                        v[next] = true;
                    }
                }
            }

            ans += cnt-- * cnt;
        }

        System.out.println(ans);
    }
}