package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불켜기_11967 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        List<Integer>[] buttons = new List[10000];
        for (int i = 0; i < 10000; i++) buttons[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int p1 = 100 * (Integer.parseInt(st.nextToken()) - 1) + Integer.parseInt(st.nextToken()) - 1;
            int p2 = 100 * (Integer.parseInt(st.nextToken()) - 1) + Integer.parseInt(st.nextToken()) - 1;

            buttons[p1].add(p2);
        }

        boolean[] v = new boolean[10000];
        boolean[] on = new boolean[10000];

        Queue<Integer> q = new ArrayDeque<>();

        q.add(0);
        v[0] = true;
        on[0] = true;

        int count = 1;

        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : buttons[now]) {
                if (!on[next]) {
                    on[next] = true;
                    count++;
                }

                if (v[next]) continue;

                for (int[] d : D) {
                    int x = next / 100 + d[0], y = next % 100 + d[1];

                    if (x >= 0 && y >= 0 && x < n &&  y < n && v[x * 100 + y]) {
                        q.add(next);
                        v[next] = true;
                        break;
                    }
                }
            }

            int r = now / 100, c = now % 100;

            for (int[] d : D) {
                int x = r + d[0], y = c + d[1];
                int z = 100 * x + y;

                if (x < 0 || y < 0 || x >= n || y >= n || v[z] || !on[z]) continue;

                q.add(z);
                v[z] = true;
            }
        }

        System.out.println(count);
    }
}