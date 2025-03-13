package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팀원모집_11578 {
    static int n, m;
    static int[] canSolve;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        canSolve = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            for (int j = 0; j < p; j++) {
                canSolve[i] |= 1 << (Integer.parseInt(st.nextToken()) - 1);
            }
        }

        min = 11;

        dfs(0, 0, 0);

        System.out.println(min == 11 ? -1 : min);
    }

    static void dfs(int d, int c, int p) {

        if (p == (1 << n) - 1) {
            min = Math.min(min, c);
            return;
        }

        if (d == m) return;

        dfs(d + 1, c, p);
        dfs(d + 1, c + 1, p | canSolve[d]);
    }
}