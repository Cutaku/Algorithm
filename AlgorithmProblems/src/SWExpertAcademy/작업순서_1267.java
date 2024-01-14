package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class 작업순서_1267 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v = ve[0], e = ve[1];

            int[] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            List<Integer>[] adj = new List[v + 1];
            for (int i = 0; i <= v; i++) adj[i] = new ArrayList<>();

            int[] pre = new int[v + 1];

            for (int i = 0; i < e; i++) {
                adj[edges[2 * i]].add(edges[2 * i + 1]);
                pre[edges[2 * i + 1]]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= v; i++) {
                if (pre[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                bw.append(String.valueOf(now)).append(" ");

                for (int next : adj[now]) {
                    pre[next]--;

                    if (pre[next] == 0) q.add(next);
                }
            }

            bw.append("\n");
        }

        bw.flush();
    }
}