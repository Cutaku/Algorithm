package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구슬찾기_2617 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        boolean[][] pos = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pos[edge[0]][edge[1]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                for (int k = 1; k <= n; k++) {
                    if (i == k || j == k) continue;

                    if (pos[j][i] && pos[i][k]) pos[j][k] = true;
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            int c1 = 0;
            int c2 = 0;

            for (int j = 1; j <= n; j++) {
                if (pos[i][j]) c1++;
                if (pos[j][i]) c2++;
            }

            if (c1 > n / 2 || c2 > n / 2) count++;
        }

        System.out.println(count);
    }
}