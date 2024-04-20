package CodeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 코드트리투어 {
    static int n;
    static List<int[]>[] adj;
    static int[] minDist;
    static int limit = 200000;
    static Map<Integer, int[]> map;
    static TreeSet<int[]> tSet;
    static Set<Integer> cancel;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        map = new HashMap<>();
        tSet = new TreeSet<>((t1, t2) -> {
            if (t1[3] == t2[3]) return t1[0] - t2[0];
            return t2[3] - t1[3];
        });

        cancel = new HashSet<>();

        int Q = Integer.parseInt(br.readLine());

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());

            int o = Integer.parseInt(st.nextToken());

            if (o == 100) {
                n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[][] aMat = new int[n + 1][n + 1];
                for (int i = 0; i < n; i++) Arrays.fill(aMat[i], 101);

                for (int i = 0; i < m; i++) {
                    int v = Integer.parseInt(st.nextToken()), u = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());

                    if (v == u) continue;

                    if (v > u) {
                        int t = u;
                        u = v;
                        v = t;
                    }

                    aMat[v][u] = Math.min(aMat[v][u], w);
                }

                adj = new List[n];
                for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (aMat[i][j] < 101) {
                            adj[i].add(new int[]{j, aMat[i][j]});
                            adj[j].add(new int[]{i, aMat[i][j]});
                        }
                    }
                }

                dijkstra(0);
            } else if (o == 200) {
                int id = Integer.parseInt(st.nextToken());
                int rev = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                if (cancel.contains(id)) continue;

                int[] trip = new int[]{id, rev, dest, rev - minDist[dest]};
                map.put(id, trip);
                tSet.add(trip);
            } else if (o == 300) {
                int id = Integer.parseInt(st.nextToken());

                if (map.containsKey(id)) {
                    int[] trip = map.remove(id);
                    tSet.remove(trip);
                } else {
                    cancel.add(id);
                }
            } else if (o == 400) {
                if (tSet.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                int[] trip = tSet.first();

                if (trip[3] < 0) {
                    sb.append("-1\n");
                    continue;
                }

                sb.append(trip[0]).append("\n");

                tSet.pollFirst();
                map.remove(trip[0]);
            } else {
                int s = Integer.parseInt(st.nextToken());

                dijkstra(s);

                TreeSet<int[]> temp = new TreeSet<>((t1, t2) -> {
                    if (t1[3] == t2[3]) return t1[0] - t2[0];
                    return t2[3] - t1[3];
                });

                for (int[] t : tSet) {
                    t[3] = t[1] - minDist[t[2]];
                    temp.add(t);
                }

                tSet = temp;
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int s) {

        minDist = new int[n];

        Arrays.fill(minDist, limit);
        minDist[s] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (minDist[now[0]] < now[1]) continue;

            for (int i = 0; i < adj[now[0]].size(); i++) {
                int[] next = adj[now[0]].get(i);

                if (minDist[next[0]] > minDist[now[0]] + next[1]) {
                    minDist[next[0]] = minDist[now[0]] + next[1];
                    pq.add(new int[]{next[0], minDist[next[0]]});
                }
            }
        }
    }
}