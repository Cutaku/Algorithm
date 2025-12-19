package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 야바위게임_23741 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        boolean[][] v = new boolean[n][2];
        boolean[] ans = new boolean[n];

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int cnt = 0;

        if (adj[x].isEmpty()) {
            System.out.println(-1);
            return;
        }

        q1.add(x);
        v[x][0] = true;

        while (!q1.isEmpty() && cnt <= y) {
            int now = q1.poll();
            int idx = 1 - cnt % 2;

            if (y % 2 == cnt % 2) ans[now] = true;

            for (int next : adj[now]) {
                if (v[next][idx]) continue;

                q2.add(next);
                v[next][idx] = true;
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ans[i]) sb.append(i + 1).append(" ");
        }

        System.out.println(sb);
    }
}