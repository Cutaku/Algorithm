package SWExpertAcademy;

import java.io.*;
import java.util.*;

class 창용마을무리의개수_7465 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];

            List<Integer>[] adj = new List[n + 1];
            for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int[] relation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                adj[relation[0]].add(relation[1]);
                adj[relation[1]].add(relation[0]);
            }

            boolean[] checked = new boolean[n + 1];

            Queue<Integer> q = new LinkedList<>();

            int count = 0;

            for (int i = 1; i <= n; i++) {
                if (checked[i]) continue;

                count++;

                checked[i] = true;

                q.add(i);

                while (!q.isEmpty()) {
                    int now = q.poll();

                    for (int next : adj[now]) {
                        if (checked[next]) continue;

                        checked[next] = true;

                        q.add(next);
                    }
                }
            }

            bw.append("#").append(String.valueOf(t)).append(" ").append(String.valueOf(count)).append("\n");
        }

        bw.flush();
    }
}