package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장난감동맹군_19240 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        a: while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;

                adj[u].add(v);
                adj[v].add(u);
            }

            int[] v = new int[n];

            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                if (v[i] > 0) continue;

                q1.add(i);
                v[i] = 1;

                int s = 2;

                while (!q1.isEmpty()) {
                    int now = q1.poll();

                    for (int next : adj[now]) {
                        if (v[next] == 0) {
                            v[next] = s;

                            q2.add(next);
                        } else if (v[next] != s) {
                            sb.append("NO\n");
                            continue a;
                        }
                    }

                    if (q1.isEmpty()) {
                        Queue<Integer> tmp = q1;
                        q1 = q2;
                        q2 = tmp;

                        s = 3 - s;
                    }
                }
            }

            sb.append("YES\n");
        }

        System.out.println(sb);
    }
}