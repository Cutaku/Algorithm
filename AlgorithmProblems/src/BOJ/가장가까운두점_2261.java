package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 가장가까운두점_2261 {
    static int n;
    static List<int[]> points;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            points.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        points.sort((p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            else return p1[0] - p2[0];
        });

        System.out.println(findMin(0, n - 1));
    }

    public static int findMin(int s, int e) {

        int d = 800000000;

        if (e - s <= 2) {
            for (int i = s; i < e; i++) {
                for (int j = i + 1; j <= e; j++) {
                    d = Math.min(d, findDistance(i, j));
                }
            }

            return d;
        }

        if (points.get(s)[0] == points.get(e)[0]) {
            int y = 20000;

            for (int i = s; i < e; i++) {
                y = Math.min(y, points.get(i + 1)[1] - points.get(i)[1]);
            }

            return y * y;
        }

        int m = (s + e) / 2;

        d = Math.min(findMin(s, m), findMin(m + 1, e));

        List<int[]> tPoints = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            int dx = points.get(i)[0] - points.get(m)[0];
            dx *= dx;

            if (dx < d) tPoints.add(points.get(i));
        }

        tPoints.sort(Comparator.comparingInt(p -> p[1]));

        int len = tPoints.size();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int dy = tPoints.get(j)[1] - tPoints.get(i)[1];
                dy *= dy;

                if (dy >= d) break;

                int dx = tPoints.get(j)[0] - tPoints.get(i)[0];
                dx *= dx;

                d = Math.min(d, dx + dy);
            }
        }

        return d;
    }

    public static int findDistance(int a, int b) {
        int[] p1 = points.get(a);
        int[] p2 = points.get(b);

        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) *(p1[1] - p2[1]);
    }
}
