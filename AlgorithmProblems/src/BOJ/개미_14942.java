package BOJ;

import java.io.*;
import java.util.*;

public class 개미_14942 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int l = (int)(Math.log(n) / Math.log(2)) + 1;

        int[] energies = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            energies[i] = Integer.parseInt(br.readLine());
        }

        List<int[]>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            adj[route[0]].add(new int[]{route[1], route[2]});
            adj[route[1]].add(new int[]{route[0], route[2]});
        }

        int[] near = new int[n + 1];
        int[] distance = new int[n + 1];
        int[][] ancestor = new int[n + 1][l + 1];

        boolean[] checked = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        checked[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            int a = now;

            while (a > 1 && distance[now] - distance[a] <= energies[now]) {
                int b = a;

                for (int i = 0; i <= l; i++) {
                    if (ancestor[a][i] == 0) break;

                    if (distance[now] - distance[ancestor[a][i]] <= energies[now]) {
                        b = ancestor[a][i];
                    } else {
                        break;
                    }
                }

                if (a == b) break;
                a = b;
            }

            near[now] = a;

            for (int[] next : adj[now]) {
                if (checked[next[0]]) continue;

                ancestor[next[0]][0] = now;
                distance[next[0]] = distance[now] + next[1];

                for (int i = 1; i < l; i++) {
                    ancestor[next[0]][i] = ancestor[ancestor[next[0]][i - 1]][i - 1];
                    if (ancestor[next[0]][i] == 0) break;
                }

                q.add(next[0]);
                checked[next[0]] = true;
            }
        }

        for (int i = 1; i <= n; i++) bw.append(String.valueOf(near[i])).append("\n");
        bw.flush();
    }
}