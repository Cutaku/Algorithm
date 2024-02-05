package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스_2606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] infected = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        infected[1] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                if (infected[next]) continue;

                count++;
                infected[next] = true;
                q.add(next);
            }
        }

        System.out.println(count);
    }
}