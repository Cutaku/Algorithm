package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 팔굽혀펴기_10564 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n, m;
        int[] scores;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            scores = new int[m];
            for (int i = 0; i < m; i++) scores[i] = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] v = new boolean[n + 1][n + 1];

            q.add(new int[]{0, 0});
            v[0][0] = true;

            int max = -1;

            while (!q.isEmpty()) {
                int[] now = q.poll();

                for (int i = 0; i < m; i++) {
                    int sum = now[1] + scores[i];
                    int pushUp = now[0] + sum;

                    if (pushUp > n || v[pushUp][sum]) continue;

                    v[pushUp][sum] = true;

                    if (pushUp == n) {
                        max = Math.max(max, sum);
                        continue;
                    }

                    q.add(new int[]{pushUp, sum});
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}