package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 거울_2344 {
    static int n, m;
    static Map<Integer, Integer> map;
    static boolean[][] box;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        box = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int idx = 1;

        for (int i = 0; i < n; i++) map.put(i * 10000 - 1, idx++);
        for (int i = 0; i < m; i++) map.put(n * 10000 + i, idx++);
        for (int i = n - 1; i >= 0; i--) map.put(i * 10000 + m, idx++);
        for (int i = m - 1; i >= 0; i--) map.put(-10000 + i, idx++);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) sb.append(light(i, 0, 0, 1)).append(" ");
        for (int i = 0; i < m; i++) sb.append(light(n - 1, i, -1, 0)).append(" ");
        for (int i = n - 1; i >= 0; i--) sb.append(light(i, m - 1, 0, -1)).append(" ");
        for (int i = m - 1; i >= 0; i--) sb.append(light(0, i, 1, 0)).append(" ");

        System.out.println(sb);
    }

    static int light(int r, int c, int x, int y) {

        if (r < 0 || c < 0 || r >= n || c >= m) {
            return map.get(r * 10000 + c);
        }

        if (box[r][c]) return light(r - y, c - x, -y, -x);
        else return light(r + x, c + y, x, y);
    }
}