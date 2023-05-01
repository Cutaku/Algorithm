package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 야구_17281 {
    static int[][] record;
    static boolean[] used;
    static int n;
    static int max;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        record = new int[n][];
        for (int i = 0; i < n; i++) record[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] order = new int[9];
        used = new boolean[9];
        used[0] = true;

        max = 0;

        dfs(order, 0);

        System.out.println(max);
    }

    static void dfs(int[] order, int o) {

        if (o == 9) {
            max = Math.max(max, calculateScore(order));
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                order[o] = i;

                if (o == 2) {
                    dfs(order, o + 2);
                } else {
                    dfs(order, o + 1);
                }

                used[i] = false;
            }
        }
    }

    static int calculateScore(int[] order) {

        int score = 0;

        int batter = 0;

        for (int i = 0; i < n; i++) {
            int out = 0;

            int[] base = new int[4];
            base[0] = 1;

            while (out < 3) {
                int result = record[i][order[batter]];

                if (result > 0) {
                    for (int j = 0; j < result; j++) score += base[3 - j];

                    for (int j = 3; j >= result; j--) base[j] = base[j - result];
                    for (int j = 1; j < result; j++) base[j] = 0;
                    base[0] = 1;
                } else {
                    out++;
                }

                batter = (batter + 1) % 9;
            }
        }

        return score;
    }
}