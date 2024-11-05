package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형으로나누기_1451 {
    static int[][] rect;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        rect = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                rect[i + 1][j + 1] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rect[i + 1][j + 1] += rect[i][j + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rect[i + 1][j + 1] += rect[i + 1][j];
            }
        }

        long max = 0;

        for (int i = 1; i < n; i++) {
            long a = sum(0, 0, i, m);

            for (int j = 1; j < m; j++) {
                max = Math.max(max, a * sum(i, 0, n, j) * sum(i, j, n, m));
            }

            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, a * sum(i, 0, j, m) * sum(j, 0, n, m));
            }
        }

        for (int i = 1; i < m; i++) {
            long a = sum(0, 0, n, i);

            for (int j = 1; j < n; j++) {
                max = Math.max(max, a * sum(0, i, j, m) * sum(j, i, n, m));
            }

            for (int j = i + 1; j < m; j++) {
                max = Math.max(max, a * sum(0, i, n, j) * sum(0, j, n, m));
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long a = sum(0, 0, i, j);

                max = Math.max(max, a * sum(0, j, i, m) * sum(i, 0, n, m));
                max = Math.max(max, a * sum(i, 0, n, j) * sum(0, j, n, m));
            }
        }

        System.out.println(max);
    }

    static int sum(int r1, int c1, int r2, int c2) {

        return rect[r2][c2] - rect[r2][c1] - rect[r1][c2] + rect[r1][c1];
    }
}