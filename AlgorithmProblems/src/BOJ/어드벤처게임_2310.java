package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 어드벤처게임_2310 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        int[] room;
        List<Integer>[] adj;
        StringTokenizer st;

        a: while ((n = Integer.parseInt(br.readLine())) > 0) {
            room = new int[n];

            adj = new List[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                room[i] = st.nextToken().charAt(0) == 'T' ? -1 : 1;
                room[i] *= Integer.parseInt(st.nextToken());

                int next;
                while ((next = Integer.parseInt(st.nextToken())) > 0) adj[i].add(next - 1);
            }

            Queue<Integer> q = new ArrayDeque<>();
            int[] v = new int[n];
            Arrays.fill(v, -1);

            q.add(0);
            v[0] = 0;

            while (!q.isEmpty()) {
                int now = q.poll();
                int money = v[now];

                if (room[now] < 0) money += room[now];
                else money = Math.max(money, room[now]);

                if(money < 0) continue;

                if (now == n - 1) {
                    sb.append("Yes\n");
                    continue a;
                }

                for (int next : adj[now]) {
                    if (v[next] < money) {
                        v[next] = money;
                        q.add(next);
                    }
                }
            }

            sb.append("No\n");
        }

        System.out.println(sb);
    }
}