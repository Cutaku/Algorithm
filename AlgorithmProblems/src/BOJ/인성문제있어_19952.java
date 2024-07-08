package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인성문제있어_19952 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int T = Integer.parseInt(br.readLine());

        a : while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] heights = new int[h * w];

            int o = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int s = (Integer.parseInt(st.nextToken()) - 1) * w + Integer.parseInt(st.nextToken()) - 1;
            int e = (Integer.parseInt(st.nextToken()) - 1) * w + Integer.parseInt(st.nextToken()) - 1;

            for (int i = 0; i < o; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                heights[x * w + y] = Integer.parseInt(st.nextToken());
            }

            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();
            boolean[] v = new boolean[h * w];

            q1.add(s);
            v[s] = true;

            while (!q1.isEmpty() && f >= 0) {
                int now = q1.poll();

                if (now == e) {
                    sb.append("잘했어!!").append("\n");
                    continue a;
                }

                for (int[] d : D) {
                    int x = now / w + d[0];
                    int y = now % w + d[1];
                    int next = x * w + y;

                    if (x < 0 || y < 0 || x >= h || y >= w || v[next] || heights[next] - heights[now] > f) continue;

                    v[next] = true;

                    q2.add(next);
                }

                if (q1.isEmpty()) {
                    Queue<Integer> tmp = q1;
                    q1 = q2;
                    q2 = tmp;

                    f--;
                }
            }

            sb.append("인성 문제있어??").append("\n");
        }

        System.out.println(sb);
    }
}