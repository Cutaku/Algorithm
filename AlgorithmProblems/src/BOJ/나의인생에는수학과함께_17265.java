package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나의인생에는수학과함께_17265 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int[][] min = new int[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE / 10);
            Arrays.fill(max[i], Integer.MIN_VALUE / 10);
        }

        min[0][0] = map[0][0] - '0';
        max[0][0] = map[0][0] - '0';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    if (i < n - 1) {
                        min[i + 1][j] = Math.min(min[i + 1][j], min[i][j]);
                        max[i + 1][j] = Math.max(max[i + 1][j], max[i][j]);
                    }
                    if (j < n - 1) {
                        min[i][j + 1] = Math.min(min[i][j + 1], min[i][j]);
                        max[i][j + 1] = Math.max(max[i][j + 1], max[i][j]);
                    }
                } else {
                    if (map[i][j] == '+') {
                        if (i < n - 1) {
                            min[i + 1][j] = Math.min(min[i + 1][j], min[i][j] + (map[i + 1][j] - '0'));
                            max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] + (map[i + 1][j] - '0'));
                        }

                        if (j < n - 1) {
                            min[i][j + 1] = Math.min(min[i][j + 1], min[i][j] + (map[i][j + 1] - '0'));
                            max[i][j + 1] = Math.max(max[i][j + 1], max[i][j] + (map[i][j + 1] - '0'));
                        }
                    } else if (map[i][j] == '-') {
                        if (i < n - 1) {
                            min[i + 1][j] = Math.min(min[i + 1][j], min[i][j] - (map[i + 1][j] - '0'));
                            max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] - (map[i + 1][j] - '0'));
                        }

                        if (j < n - 1) {
                            min[i][j + 1] = Math.min(min[i][j + 1], min[i][j] - (map[i][j + 1] - '0'));
                            max[i][j + 1] = Math.max(max[i][j + 1], max[i][j] - (map[i][j + 1] - '0'));
                        }
                    } else {
                        if (i < n - 1) {
                            min[i + 1][j] = Math.min(min[i + 1][j], min[i][j] * (map[i + 1][j] - '0'));
                            max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] * (map[i + 1][j] - '0'));
                        }

                        if (j < n - 1) {
                            min[i][j + 1] = Math.min(min[i][j + 1], min[i][j] * (map[i][j + 1] - '0'));
                            max[i][j + 1] = Math.max(max[i][j + 1], max[i][j] * (map[i][j + 1] - '0'));
                        }
                    }
                }

            }
        }

        System.out.println(max[n - 1][n - 1] + " " + min[n - 1][n - 1]);
    }
}