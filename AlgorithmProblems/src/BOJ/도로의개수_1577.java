package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 도로의개수_1577 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        int k = Integer.parseInt(br.readLine());

        boolean[][][] construction = new boolean[n + 1][m + 1][2];

        for (int i = 0; i < k; i++) {
            int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = Math.min(position[0], position[2]);
            int x2 = Math.max(position[0], position[2]);
            int y2 = Math.max(position[1], position[3]);

            if (x1 != x2) construction[x2][y2][0] = true;
            else construction[x2][y2][1] = true;
        }

        long[][] count = new long[n + 1][m + 1];
        count[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 && !construction[i][j][0]) count[i][j] += count[i - 1][j];
                if (j > 0 && !construction[i][j][1]) count[i][j] += count[i][j - 1];
            }
        }

        System.out.println(count[n][m]);
    }
}