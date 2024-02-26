package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 곡선자르기_14865 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] points = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][1] /= Math.abs(points[i][1]);
        }

        points[n] = points[0];

        List<int[]> list = new ArrayList<>();

        int limit = Integer.MAX_VALUE;

        int lastUp = limit;
        int firstBelow = limit;

        for (int i = 0; i < n; i++) {
            if (points[i + 1][1] * points[i][1] >= 0) continue;

            if (points[i + 1][1] > 0) {
                lastUp = points[i][0];
            } else {
                if (lastUp < limit) {
                    if (lastUp < points[i][0]) list.add(new int[]{lastUp, points[i][0]});
                    else list.add(new int[]{points[i][0], lastUp});
                } else {
                    firstBelow = points[i][0];
                }
            }
        }

        if (firstBelow < limit) {
            if (firstBelow < lastUp) list.add(new int[] {firstBelow, lastUp});
            else list.add(new int[] {lastUp, firstBelow});
        }

        int notContain = 1;
        int notContained = 1;

        list.sort(Comparator.comparingInt(x -> x[0]));

        int max = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1)[1] < list.get(i)[0]) notContain++;
            if (max < list.get(i)[0]) notContained++;

            max = Math.max(max, list.get(i)[1]);
        }

        System.out.printf("%d %d", notContained, notContain);
    }
}
