package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 제곱수찾기_1025 {
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] table = new int[n][m];

        Set<Integer> power = new HashSet<>();

        for (int i = 0; i * i < 1000000000; i++) {
            power.add(i * i);
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                table[i][j] = line.charAt(j) - '0';
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(power.contains(table[0][0]) ? table[0][0] : -1);
            return;
        }

        int max = -1;

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    for (int j2 = 0; j2 < m; j2++) {
                        if (i1 == i2 && j1 == j2) continue;

                        int r = i1;
                        int c = j1;
                        int dr = i2 - i1;
                        int dc = j2 - j1;
                        int sum = 0;

                        while (inRange(r, c)) {
                            sum *= 10;
                            sum += table[r][c];

                            if (power.contains(sum)) max = Math.max(max, sum);

                            r += dr;
                            c += dc;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    static boolean inRange(int i, int j) {

        return i >= 0 && i < n && j >= 0 && j < m;
    }
}