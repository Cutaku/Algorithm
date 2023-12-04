package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 램프_1034 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];

        boolean[][] lamps = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') lamps[i][j] = true;
            }
        }

        int k = Integer.parseInt(br.readLine());

        while (k > m) k -= 2;

        boolean[] v = new boolean[n];

        for (int i = 0; i < n; i++) {
            int c = 0;

            for (int j = 0; j < m; j++) {
                if (!lamps[i][j]) c++;
            }

            if (c > k || c % 2 != k % 2) v[i] = true;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;

            v[i] = true;

            int c = 1;

            for (int j = i + 1; j < n; j++) {
                if (isSame(lamps[i], lamps[j])) {
                    c++;
                    v[j] = true;
                }
            }

            max = Math.max(max, c);
        }

        System.out.println(max);
    }

    public static boolean isSame(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}