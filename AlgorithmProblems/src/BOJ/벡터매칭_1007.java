package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벡터매칭_1007 {
    static int n;
    static int[][] points;
    static double min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            points = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            dfs(0, 0, 0, 0, 0);

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int l, int r, long x, long y, int d) {

        if (d == n) {
            min = Math.min(min, Math.sqrt(x * x + y * y));
            return;
        }

        if (l < n / 2) dfs(l + 1, r, x + points[d][0], y + points[d][1], d + 1);
        if (r < n / 2) dfs(l, r + 1, x - points[d][0], y - points[d][1], d + 1);
    }
}