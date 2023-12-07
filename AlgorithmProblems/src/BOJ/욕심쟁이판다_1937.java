package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 욕심쟁이판다_1937 {
    static int n;
    static int[][] forest;
    static int[][] max;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        forest = new int[n][];
        for (int i = 0; i < n; i++) forest[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        max = new int[n][n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, findMax(i, j));
            }
        }

        System.out.println(ans);
    }

    public static int findMax(int i, int j) {

        if (max[i][j] > 0) return max[i][j];

        max[i][j] = 1;

        int[][] D = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] d : D) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || y < 0 || x >= n || y >= n || forest[i][j] >= forest[x][y]) continue;

            max[i][j] = Math.max(max[i][j], findMax(x, y) + 1);
        }

        return max[i][j];
    }
}