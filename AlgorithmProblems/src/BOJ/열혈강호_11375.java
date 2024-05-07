package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 열혈강호_11375 {
    static int n, m;
    static int[][] works;
    static int[] assign;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        works = new int[n][];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());

            works[i] = new int[c];

            for (int j = 0; j < c; j++) {
                works[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        assign = new int[m];
        Arrays.fill(assign, -1);

        int count = 0;

        for (int i = 0; i < n; i++) {
            v = new boolean[m];

            if (dfs(i)) count++;
        }

        System.out.println(count);
    }

    static boolean dfs(int w) {

        for (int work : works[w]) {
            if (v[work]) continue;
            v[work] = true;

            if (assign[work] < 0|| dfs(assign[work])) {
                assign[work] = w;
                return true;
            }
        }

        return false;
    }
}