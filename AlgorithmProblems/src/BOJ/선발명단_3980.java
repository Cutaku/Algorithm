package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 선발명단_3980 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        for (int t = 0; t < c; t++) {

            int[][] abilities = new int[11][];
            for(int i = 0; i < 11; i++) abilities[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean[] used = new boolean[11];

           int[] max = new int[1];

            dfs(abilities, used, max, 0, 0);

            System.out.println(max[0]);
        }
    }

    static void dfs(int[][] abilities, boolean[] used, int[] max, int sum, int d) {

        if (d == 11) {
            max[0] = Math.max(max[0], sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (used[i] || abilities[i][d] == 0) continue;

            used[i] = true;

            dfs(abilities, used, max, sum + abilities[i][d], d + 1);

            used[i] = false;
        }
    }
}