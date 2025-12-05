package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 풍성한트리_32934 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) {
                q1.add(i);
                v[i] = true;
            } else if (adj[i].size() != 3) {
                System.out.println(-1);
                return;
            }
        }

        int s = q1.size();

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int next : adj[now]) {
                if (v[next]) continue;

                v[next] = true;
                q2.add(next);
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                int t = q1.size();

                if (t == 1 && s == 3) {
                    System.out.println(1);
                    System.out.println(q1.poll() + 1);
                    return;
                }

                if (t * 2 != s) {
                    System.out.println(-1);
                    return;
                }

                s = t;
            }
        }

        System.out.println(-1);
    }
}