package BOJ;
import java.io.*;
import java.util.*;

public class 원수의원수_23818 {
    static int[] root;
    static int[] color; 
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        root = new int[n];
        color = new int[n];
        adj = new List[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            
            adj[a].add(new int[]{t, b});
            adj[b].add(new int[]{t, a});

            a = find(a);
            b = find(b);

            root[Math.max(a, b)] = Math.min(a, b);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (color[find(i)] > 0) continue;

            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int[] next : adj[now]) {
                    if (color[next[1]] == 0) {
                        color[next[1]] = next[0] == 0 ? color[now] : 3 - color[now];

                        q.add(next[1]);
                    } else {
                        if ((color[now] - color[next[1]] + next[0]) % 2 != 0) {
                            color[find(now)] = 3;
                            q = new ArrayDeque<>();
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (find(a) != find(b)) sb.append("Unknown\n");
            else if (color[find(a)] == 3) sb.append("Error\n");
            else if (color[a] == color[b]) sb.append("Friend\n");
            else sb.append("Enemy\n");
        }

        System.out.println(sb);
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}