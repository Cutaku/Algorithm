package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기2_17472 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int g = 2;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.add(i * m + j);
                    map[i][j] = g;
                    
                    while (!q.isEmpty()) {
                        int now = q.poll();
                        
                        int x = now / m;
                        int y = now % m;

                        for (int[] d : D) {
                            int nx = x + d[0];
                            int ny = y + d[1];
                            
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 1) continue;
                            
                            q.add(nx * m + ny);
                            map[nx][ny] = g;
                        }
                    }
                    
                    g++;
                }
            }
        }

        int[][] dist = new int[g][g];
        for (int i = 0; i < g; i++) {
            Arrays.fill(dist[i], 10);
        }

        for (int i = 0; i < n; i++) {
            int gNum = map[i][0];

            int conti = 0;

            for (int j = 1; j < m; j++) {
                int num = map[i][j];

                if (num == 0) conti++;
                else if (num != gNum) {
                    if (gNum > 0 && conti > 1) {
                        dist[gNum][num] = Math.min(dist[gNum][num], conti);
                        dist[num][gNum] = dist[gNum][num];
                    }

                    gNum = num;
                }

                if (num > 0) conti = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int gNum = map[0][i];

            int conti = 0;

            for (int j = 1; j < n; j++) {
                int num = map[j][i];

                if (num == 0) conti++;
                else if (num != gNum) {
                    if (gNum > 0 && conti > 1) {
                        dist[gNum][num] = Math.min(dist[gNum][num], conti);
                        dist[num][gNum] = dist[gNum][num];
                    }

                    gNum = num;
                }

                if (num > 0) conti = 0;
            }
        }

        root = new int[g];
        for (int i = 2; i < g; i++) root[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d[2]));

        for (int i = 2; i < g - 1; i++) {
            for (int j = i + 1; j < g; j++) {
                if (dist[i][j] < 10) pq.add(new int[]{i, j, dist[i][j]});
            }
        }

        int sum = 0;
        int count = 0;

        while (count < g - 3 && !pq.isEmpty()) {
            int[] edge = pq.poll();

            int v1 = find(edge[0]);
            int v2 = find(edge[1]);

            if (v1 != v2) {
                sum += edge[2];

                root[Math.max(v1, v2)] = Math.min(v1, v2);

                count++;
            }
        }

        if (count < g - 3) System.out.println(-1);
        else System.out.println(sum);
    }

    static int find(int x) {

        if (x == root[x]) return x;
        else return root[x] = find(root[x]);
    }
}