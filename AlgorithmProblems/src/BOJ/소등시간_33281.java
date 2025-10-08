package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소등시간_33281 {
    static int n, m;
    static int[] count;
    static boolean[][] bulbs;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = new int[m];
        bulbs = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            boolean first = line.charAt(0) == '1';

            for (int j = 1; j < m; j++) {
                bulbs[i][j] = (line.charAt(j) == '1') ^ first;
                if (bulbs[i][j]) count[j]++;
            }
        }

        int ans = 0;


        for (int i = 0; i <= n; i++) {
            if (check(i)) ans++;
        }

        System.out.println(ans);
    }

    static boolean check(int r) {

        for (int i = 1; i < m; i++) {
            int c = count[i];

            if (r < n) c += !bulbs[r][i] ? 1 : -1;

            if (c > 1) return false;
        }

        return true;
    }
}