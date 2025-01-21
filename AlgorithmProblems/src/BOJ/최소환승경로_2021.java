package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소환승경로_2021 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n + l];
        for (int i = 0; i < n + l; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int line = n + i;

            while (true) {
                int station = Integer.parseInt(st.nextToken()) - 1;

                if (station == -2) break;

                adj[line].add(station);
                adj[station].add(line);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1, end = Integer.parseInt(st.nextToken()) - 1;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        boolean[] v = new boolean[n + l];

        q1.add(start);
        v[start] = true;

        int t = 0;

        while (!q1.isEmpty()) {
            int now = q1.poll();

            if (now == end) {
                System.out.println(Math.max(0, t / 2 - 1));
                return;
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

                t++;
            }
        }

        System.out.println(-1);
    }
}