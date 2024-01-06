package SWExpertAcademy;

import java.io.*;
import java.util.*;

public class 영준이의진짜BFS_1855 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            bw.append("#").append(String.valueOf(tc)).append(" ");

            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            List<Integer>[] children = new List[n + 1];
            for (int i = 1; i <= n; i++) children[i] = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) children[Integer.parseInt(st.nextToken())].add(i + 2);

            int[] depth = new int[n  + 1];
            int[][] ancestors = new int[n + 1][18];

            Queue<Integer> q = new LinkedList<>();
            q.add(1);

            while (!q.isEmpty()) {
                int p = q.poll();

                for (int child : children[p]) {
                    q.add(child);

                    depth[child] = depth[p] + 1;
                    ancestors[child][0] = p;

                    for (int i = 1; i < 18; i++) {
                        ancestors[child][i] = ancestors[ancestors[child][i - 1]][i - 1];
                        if (ancestors[child][i] == 0) break;
                    }
                }
            }

            long distance = 0;
            int last = 1;

            q.addAll(children[1]);

            while (!q.isEmpty()) {
                int now = q.poll();
                q.addAll(children[now]);

                int c = findLCA(depth, ancestors, last, now);

                distance += depth[last] + depth[now] - 2L * depth[c];

                last = now;
            }

            bw.append(String.valueOf(distance)).append("\n");
        }

        bw.flush();
    }

    public static int findLCA(int[] depth, int[][] ancestors, int a, int b) {

        if (depth[a] > depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        while (depth[a] < depth[b]) {
            int i = 17;

            while (depth[ancestors[b][i]] < depth[a]) i--;

            b = ancestors[b][i];
        }

        while (a != b) {
            int i = 17;

            while (i > 0 && ancestors[a][i] == ancestors[b][i]) i--;

            a = ancestors[a][i];
            b = ancestors[b][i];
        }

        return a;
    }
}