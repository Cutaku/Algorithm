package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 얼음깨기펭귄_21738 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new  StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()) - 1;

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

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

        q1.add(p);
        v[p] = true;

        int ans = n - 1;
        int d = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now < s) {
                if (ans < n - 1) {
                    System.out.println(ans - d);
                    return;
                } else {
                    ans -= d;
                }
            }

            for (int next : adj[now]) {
                if (v[next]) continue;

                q2.add(next);
                v[next] = true;
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                d++;
            }
        }
    }
}