package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 소문난칠공주_1941 {
    static boolean[][] som;
    static int count;
    static int[] group;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        som = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();

            for (int j = 0; j < 5; j++) {
                som[i][j] = line.charAt(j) == 'S';
            }
        }

        count = 0;
        group = new int[7];

        dfs(0, 0, 0);

        System.out.println(count);
    }

    static boolean isConnected() {

        boolean[] v = new boolean[7];

        List<Integer> list = new ArrayList<>();
        int idx = 0;

        list.add(0);
        v[0] = true;

        while (idx < list.size()) {
            int now = group[list.get(idx++)];
            int r = now / 5, c = now % 5;

            for (int i = 0; i < 7; i++) {
                if (v[i]) continue;

                int next = group[i];

                int x = next / 5, y = next % 5;

                if ((r == x && Math.abs(c - y) == 1) || (c == y && Math.abs(r - x) == 1)) {
                    v[i] = true;
                    list.add(i);
                }
            }
        }

        return list.size() == 7;
    }

    static void dfs(int d, int s, int c) {

        if (7 - d + c < 4) return;

        if (d == 7) {
            if (isConnected()) count++;

            return;
        }

        for (int i = s; i < 25; i++) {
            group[d] = i;
            dfs(d + 1, i + 1, c + (som[i / 5][i % 5] ? 1 : 0));
        }
    }
}