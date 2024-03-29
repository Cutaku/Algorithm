package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSAT_6_염기서열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        String[] genes = new String[n];

        for (int i = 0; i < n; i++) genes[i] = br.readLine();

        boolean[][] match = new boolean[n][n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (match(genes[i], genes[j])) {
                    match[i][j] = true;
                }
            }
        }

        int k = 1 << n;

        int[] min = new int[k];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 1; i < k; i++) {
            if (matchAll(i, match)) min[i] = 1;
        }

        for (int i = 2; i < k; i++) {
            for (int j = 1; j < i; j++) {
                min[i | j] = Math.min(min[i | j], min[i] + min[j]);
            }
        }

        System.out.println(min[k - 1]);
    }

    static boolean matchAll(int b, boolean[][] match) {

        int n = match.length;

        for (int i = 0; i < n - 1; i++) {
            if ((b & (1 << i)) == 0) continue;

            for (int j = i + 1; j < n; j++) {
                if ((b & (1 << j)) == 0) continue;

                if (!match[i][j]) return false;
            }
        }

        return true;
    }

    static boolean match(String g1, String g2) {

        int m = g1.length();

        for (int i = 0; i < m; i++) {
            char c1 = g1.charAt(i), c2 = g2.charAt(i);

            if (c1 != '.' && c2 != '.' && c1 != c2) return false;
        }

        return true;
    }
}
