package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 루머_19538 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();


        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a;

            while ((a = Integer.parseInt(st.nextToken())) > 0) {
                adj[i].add(a - 1);
                adj[a - 1].add(i);
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int m = Integer.parseInt(br.readLine());

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken()) - 1;

            q1.add(a);
            ans[a] = 0;
        }

        int t = 1;
        int[] cnt = new int[n];

        while (!q1.isEmpty()) {
            int now = q1.poll();

            for (int next : adj[now]) {
                if (ans[next] > -1) continue;

                if (++cnt[next] >= (adj[next].size() + 1) / 2) {
                    q2.add(next);
                    ans[next] = t;
                }
            }

            if (q1.isEmpty()) {
                Queue<Integer> tmp = q1;
                q1 = q2;
                q2 = tmp;

                t++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ans[i]).append(" ");

        System.out.println(sb);
    }
}