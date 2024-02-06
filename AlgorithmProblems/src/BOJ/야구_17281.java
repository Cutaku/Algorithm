package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 야구_17281 {
    static int n;
    static int[][] results;
    static int max;
    static int[] order = new int[9];
    static boolean[] checked = new boolean[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        results = new int[n][];
        for (int i = 0; i < n; i++) {
            results[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        max = 0;

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int d) {

        if (d == 9) {
            max = Math.max(max, score());
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (checked[i]) continue;

            order[d] = i;
            checked[i] = true;

            if (d == 2) dfs(d + 2);
            else dfs(d + 1);

            checked[i] = false;
        }
    }

    static int score() {

        int batter = 0;
        int score = 0;

        for (int i = 0; i < n; i++) {
            int out = 0;

            int field = 0;

            while (out < 3) {
                int result = results[i][order[batter++]];
                batter %= 9;

                if (result == 0) {
                    out++;
                    continue;
                }

                field++;
                field <<= result;
                score += Integer.bitCount(field / 16);
                field %= 16;
            }
        }

        return score;
    }
}