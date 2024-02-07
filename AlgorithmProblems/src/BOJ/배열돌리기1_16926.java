package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 배열돌리기1_16926 {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] nmr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nmr[0];
        m = nmr[1];
        int r = nmr[2];

        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] ans = new int[n][m];

        int[] ind = {0, 0};

        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            int d = 2 * (m - i * 2) +  2 * (n - i * 2) - 4;
            int q = r % d;

            int[] dir ={0, 1};
            int[] cDir = {0, 1};

            int[] copy = ind.clone();
            for (int j = 0; j < q; j++) {
                next(copy, cDir, i);
            }

            for (int j = 0; j < d; j++) {
                ans[ind[0]][ind[1]] = matrix[copy[0]][copy[1]];
                next(ind, dir, i);
                next(copy, cDir, i);
            }

            ind[0]++;
            ind[1]++;
        }

        for (int[] line : ans) {
            for (int l : line) {
                sb.append(l).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void next(int[] ind, int[] dir, int i) {

        int ni = ind[0] + dir[0];
        int nj = ind[1] + dir[1];

        if (ni < i || nj < i || ni >= n - i || nj >= m - i) {
            changeDir(dir);

            ni = ind[0] + dir[0];
            nj = ind[1] + dir[1];
        }

        ind[0] = ni;
        ind[1] = nj;
    }

    static void changeDir(int[] dir) {

        int t = dir[0];
        dir[0] = dir[1];
        dir[1] = -t;
    }
}