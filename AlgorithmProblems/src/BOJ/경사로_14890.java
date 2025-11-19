package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_14890 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        a: for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];

            for (int j = 1; j < n; j++) {
                if (Math.abs(map[i][j - 1] - map[i][j]) > 1) continue a;

                if (map[i][j - 1] - map[i][j] == 1) {
                    for (int k = 0; k < l; k++) {
                        if (j + k >= n || map[i][j] != map[i][j + k] || v[j + k]) continue a;

                        v[j + k] = true;
                    }
                } else if (map[i][j] - map[i][j - 1] == 1) {
                    for (int k = 1; k <= l; k++) {
                        if (j - k < 0 || map[i][j - k] != map[i][j - 1] || v[j - k]) continue a;

                        v[j - k] = true;
                    }
                }
            }

            ans++;
        }

        a: for (int i = 0; i < n; i++) {
            boolean[] v = new boolean[n];

            for (int j = 1; j < n; j++) {
                if (Math.abs(map[j - 1][i] - map[j][i]) > 1) continue a;

                if (map[j - 1][i] - map[j][i] == 1) {
                    for (int k = 0; k < l; k++) {
                        if (j + k >= n || map[j][i] != map[j + k][i] || v[j + k]) continue a;

                        v[j + k] = true;
                    }
                } else if (map[j][i] - map[j - 1][i] == 1) {
                    for (int k = 1; k <= l; k++) {
                        if (j - k < 0 || map[j - k][i] != map[j - 1][i] || v[j - k]) continue a;

                        v[j - k] = true;
                    }
                }
            }

            ans++;
        }

        System.out.println(ans);
    }
}