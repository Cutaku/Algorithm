package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기_16987 {
    static int n;
    static int[][] eggs;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        eggs = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        max = 0;

        dfs(0, 0);

        System.out.println(max);
    }

    static void dfs(int d, int c) {

        max = Math.max(max, c);

        if (d == n) return;

        if (eggs[d][0] < 1) {
            dfs(d + 1, c);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == d || eggs[i][0] < 1) continue;

            eggs[d][0] -= eggs[i][1];
            eggs[i][0] -= eggs[d][1];

            int plus = 0;

            if (eggs[d][0] < 1) plus++;
            if (eggs[i][0] < 1) plus++;

            dfs(d + 1, c + plus);

            eggs[d][0] += eggs[i][1];
            eggs[i][0] += eggs[d][1];
        }
    }
}