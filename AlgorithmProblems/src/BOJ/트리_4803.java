package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리_4803 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = 0;

        while (true) {
            c++;

            int count = 0;

            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nm[0], m = nm[1];

            if (n == 0) return;

            List<Integer>[] adj = new List[n + 1];
            for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }

            boolean[] v = new boolean[n + 1];

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (v[i]) continue;

                v[i] = true;

                boolean isTree = true;

                q.add(i);

                int vertex = 0;
                int edge = 0;

                while (!q.isEmpty()) {
                    int now = q.poll();

                    vertex++;
                    edge += adj[now].size();

                    for (int next : adj[now]) {
                        if (v[next])  continue;
                        v[next] = true;
                        q.add(next);
                    }
                }

                if (vertex - 1 == edge / 2) count++;
            }

            if (count == 0) {
                System.out.println("Case " + c + ": No trees.");
            } else if (count == 1) {
                System.out.println("Case " + c + ": There is one tree.");
            } else {
                System.out.println("Case " + c + ": A forest of " + count + " trees.");
            }
        }
    }
}