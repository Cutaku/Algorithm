package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소2_17141 {
    static int n, m;
    static long[] lab;
    static int sCount;
    static List<int[]> starts;
    static int[] start;
    static int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new long[n];
        sCount = m;
        starts = new ArrayList<>();
        start = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());

                if (p == 1) {
                    sCount++;
                    lab[i] |= 1L << j;
                } else if (p == 2) {
                    starts.add(new int[]{i, j});
                }
            }
        }

        min = n * n;

        dfs(0, 0);

        System.out.println(min == n * n ? -1 : min);
    }

    static void dfs(int d, int s) {

        if (d == m) {
            long[] temp = lab.clone();
            min = Math.min(min,bfs());
            lab = temp;

            return;
        }

        for (int i = s; i < starts.size(); i++) {
            start[d] = i;
            dfs(d + 1, i + 1);
        }
    }

    static int bfs() {

        if (sCount == n * n) return 0;

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        for (int i : start) {
            int[] s = starts.get(i);

            q1.add(s);
            lab[s[0]] |= 1L << s[1];
        }

        int c = -1;
        int count = sCount;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= n || y >= n || (lab[x] & (1L << y)) > 0) continue;

                count++;

                lab[x] |= 1L << y;

                q2.add(new int[]{x, y});
            }

            if (q1.isEmpty()) {
                Queue<int[]> tmp = q1;
                q1 = q2;
                q2 = tmp;

                if (++c >= min) return min;
            }
        }

        return count == n * n ? c : n * n;
    }
}