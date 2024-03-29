package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HSAT_2_사물인식최소면적프로그램 {
    static int n, k;
    static List<Integer> xValues;
    static List<Integer> yValues;
    static int[][] points;
    static int[][][] colors;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        points = new int[n][3];

        xValues = new ArrayList<>();
        yValues = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) points[i][j] = Integer.parseInt(st.nextToken());

            if (!xValues.contains(points[i][0])) xValues.add(points[i][0]);
            if (!yValues.contains(points[i][1])) yValues.add(points[i][1]);
        }

        Collections.sort(xValues);
        Collections.sort(yValues);

        Map<Integer, Integer> X = new HashMap<>();
        Map<Integer, Integer> Y = new HashMap<>();

        for (int i = 0; i < xValues.size(); i++) {
            X.put(xValues.get(i), i);
        }

        for (int i = 0; i < yValues.size(); i++) {
            Y.put(yValues.get(i), i);
        }

        colors = new int[xValues.size()][yValues.size()][k];

        for (int[] point : points) {
            colors[X.get(point[0])][Y.get(point[1])][point[2] - 1]++;
        }

        for (int i = 0; i < xValues.size(); i++) {
            for (int j = 1; j < yValues.size(); j++) {
                for (int l = 0; l < k; l++) {
                    colors[i][j][l] += colors[i][j - 1][l];
                }
            }
        }

        for (int i = 1; i < xValues.size(); i++) {
            for (int j = 0; j < yValues.size(); j++) {
                for (int l = 0; l < k; l++) {
                    colors[i][j][l] += colors[i - 1][j][l];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < xValues.size(); i++) {
            int x1 = xValues.get(i);

            for (int j = i; j < xValues.size(); j++) {
                int x2 = xValues.get(j);

                for (int m = 0; m < yValues.size(); m++) {
                    int y1 = yValues.get(m);

                    for (int l = m; l < yValues.size(); l++) {
                        int y2 = yValues.get(l);

                        if (containsAll(i, j, m, l)) {
                            min = Math.min(min, (x2 - x1) * (y2 - y1));
                        }
                    }
                }
            }
        }

        System.out.println(min);
    }

    static boolean containsAll(int x1, int x2, int y1, int y2) {

        for (int i = 0; i < k; i++) {
            int count = colors[x2][y2][i];

            if (x1 > 0) count -= colors[x1 - 1][y2][i];
            if (y1 > 0) count -= colors[x2][y1 - 1][i];
            if (x1 > 0 && y1 > 0) count += colors[x1 - 1][y1 - 1][i];

            if (count == 0) return false;
        }

        return true;
    }
}
