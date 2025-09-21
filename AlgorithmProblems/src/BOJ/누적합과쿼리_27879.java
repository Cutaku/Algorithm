package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 누적합과쿼리_27879 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, int[][][]> map = new HashMap<>();

        map.put("aa", new int[n + 1][n + 1][2]);
        map.put("ab", new int[n + 1][n + 1][2]);
        map.put("ba", new int[n + 1][n + 1][2]);
        map.put("bb", new int[n + 1][n + 1][2]);


        String[][] board = new String[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                for (int[][][] value : map.values()) {
                    value[i + 1][j + 1][0] += value[i][j + 1][0];
                    value[i + 1][j + 1][1] += value[i + 1][j][1];
                }

                board[i][j] = st.nextToken();

                if (i > 0) {
                    String key = board[i - 1][j] + board[i][j];
                    int[][][] value = map.get(key);

                    value[i + 1][j + 1][0]++;
                }

                if (j > 0) {
                    String key = board[i][j - 1] + board[i][j];
                    int[][][] value = map.get(key);

                    value[i + 1][j + 1][1]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int[][][] value : map.values()) {
                    value[i + 1][j + 1][0] += value[i + 1][j][0];
                    value[i + 1][j + 1][1] += value[i][j + 1][1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken()), j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken()), j2 = Integer.parseInt(st.nextToken());

            int[][][] v = map.get(st.nextToken());

            int res = v[i2][j2][0] - v[i1][j2][0] - v[i2][j1 - 1][0] + v[i1][j1 - 1][0];
            res += v[i2][j2][1] - v[i1 - 1][j2][1] - v[i2][j1][1] + v[i1 - 1][j1][1];

            sb.append(res).append("\n");
        }

        System.out.println(sb);
    }
}