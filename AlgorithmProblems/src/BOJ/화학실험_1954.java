package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 화학실험_1954 {
    static int n;
    static int[][] solutions;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        solutions = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            solutions[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m; i++) {
            dfs(0, m, solutions[0][0] * i + solutions[0][1]);
        }

        System.out.println(0);
    }

    static void dfs(int d, int left, int gas) {

        if (d == n) {
            if (left == 0) {
                System.out.println(gas);
                System.exit(0);
            }

            return;
        }

        int[] solution = solutions[d];

        if ((gas - solution[1]) % solution[0] > 0) return;
        if ((gas - solution[1]) / solution[0] == 0) return;

        dfs(d + 1, left - (gas - solution[1]) / solution[0], gas);
    }
}