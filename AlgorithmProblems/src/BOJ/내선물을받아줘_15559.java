package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 내선물을받아줘_15559 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        String[] map = new String[n];
        for (int i = 0; i < n; i++) map[i] = br.readLine();

        Map<Character, int[]> D = new HashMap<>();
        D.put('S', new int[]{1, 0});
        D.put('E', new int[]{0, 1});
        D.put('N', new int[]{-1, 0});
        D.put('W', new int[]{0, -1});

        int[][] v = new int[n][m];
        int w = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            a: for (int j = 0; j < m; j++) {
                if (v[i][j] > 0) continue;

                v[i][j] = w;
                int r = i, c = j;

                while (true) {
                    int[] d = D.get(map[r].charAt(c));

                    r += d[0];
                    c += d[1];

                    if (v[r][c] > 0) {
                        if (v[r][c] == w) ans++;

                        w++;
                        continue a;
                    }

                    v[r][c] = w;
                }
            }
        }

        System.out.println(ans);
    }
}