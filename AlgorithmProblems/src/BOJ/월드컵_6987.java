package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 월드컵_6987 {
    static List<int[]> games;
    static int[][] results;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        games = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                games.add(new int[]{i, j});
            }
        }

        results = new int[6][3];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 18; j++)  results[j / 3][j % 3] = Integer.parseInt(st.nextToken());

            if (dfs(0)) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }

    static boolean dfs(int d) {

        if (d == 15) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (results[i][j] != 0) return false;
                }
            }

            return true;
        }

        for (int i = 0; i < 3; i++) {
            if (next(d, i, 2 - i)) return true;
        }

        return false;
    }

    static boolean next(int d, int i, int j) {

        int[] game = games.get(d);

        if (results[game[0]][i] > 0 && results[game[1]][j] > 0) {
            results[game[0]][i]--;
            results[game[1]][j]--;
            if (dfs(d + 1)) return true;
            results[game[0]][i]++;
            results[game[1]][j]++;
        }

        return false;
    }
}
