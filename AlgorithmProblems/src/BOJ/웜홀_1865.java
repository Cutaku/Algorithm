package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 웜홀_1865 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[] nmw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = nmw[0], m = nmw[1], w = nmw[2];
            boolean flag = false;

            List<int[]> roads = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] reverse = new int[3];
                reverse[0] = road[1];
                reverse[1] = road[0];
                reverse[2] = road[2];

                roads.add(road);
                roads.add(reverse);
            }

            for (int i = 0; i < w; i++) {
                int[] road = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                road[2] *= -1;
                roads.add(road);
            }

            int[] times = new int[n + 1];
            Arrays.fill(times, 0);

            boolean pos = false;

            for (int i = 0; i < n; i++) {
                for (int[] road : roads) {
                    int from = road[0];
                    int to  = road[1];
                    int time = road[2];

                    if (i == n - 1 && times[to] > times[from] + time) pos = true;

                    times[to] = Math.min(times[to], times[from] + time);
                }
            }

            if (pos) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}