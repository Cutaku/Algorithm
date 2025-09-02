package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마약수사대_17220 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[n];
        for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();

        boolean[] v =  new boolean[n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();

            int from = line.charAt(0) - 'A';
            int to = line.charAt(2) - 'A';

            adj[from].add(to);
            v[to] = true;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (v[i]) v[i] = false;
            else q.add(i);
        }

        boolean[] arrested = new boolean[n];

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            arrested[st.nextToken().charAt(0) - 'A'] = true;
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (arrested[now]) continue;

            for (int next : adj[now]) {
                if (v[next] || arrested[next]) continue;

                v[next] = true;
                cnt++;

                q.add(next);
            }
        }

        System.out.println(cnt);
    }
}