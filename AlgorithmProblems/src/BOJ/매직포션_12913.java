package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 매직포션_12913 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] min = new int[n][k + 1];
        for (int i = 1; i < n; i++) Arrays.fill(min[i], 500);

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = i + 1; j < n; j++) {
                cost[i][j] = line.charAt(j) - '0';
                cost[j][i] = cost[i][j];
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (min[now[0]][now[1]] < now[2]) continue;

            if (now[0] == 1) {
                System.out.println(((double) now[2]) / 2);
                return;
            }

            for (int i = 0; i < n; i++) {
                if (i == now[0]) continue;

                if (min[i][now[1]] > now[2] + 2 * cost[now[0]][i]) {
                    min[i][now[1]] = now[2] + 2 * cost[now[0]][i];
                    pq.add(new int[]{i, now[1],  now[2] + 2 * cost[now[0]][i]});
                }

                if (now[1] < k && min[i][now[1] + 1] > now[2] + cost[now[0]][i]) {
                    min[i][now[1] + 1] = now[2] + cost[now[0]][i];
                    pq.add(new int[]{i, now[1] + 1, now[2] + cost[now[0]][i]});
                }
            }
        }
    }
}