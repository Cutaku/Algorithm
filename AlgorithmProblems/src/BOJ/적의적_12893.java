package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 적의적_12893 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] > 0) continue;

            q1.add(i);
            color[i] = 1;

            while (!q1.isEmpty()) {
                int node = q1.poll();

                for (int next : adj[node]) {
                    if (color[next] == 0) {
                        q2.add(next);
                        color[next] = 3 - color[node];
                    } else if (color[next] == color[node]) {
                        System.out.println(0);
                        return;
                    }
                }

                if (q1.isEmpty()) {
                    Queue<Integer> tmp = q1;
                    q1 = q2;
                    q2 = tmp;
                }
            }
        }

        System.out.println(1);
    }
}