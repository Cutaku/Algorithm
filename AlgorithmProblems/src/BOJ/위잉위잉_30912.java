package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 위잉위잉_30912 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] positions = new long[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            positions[i] = new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
        }

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());

        Arrays.sort(positions, (a, b) -> {
            long x1 = a[0] - x, y1 = a[1] - y;
            long x2 = b[0] - x, y2 = b[1] - y;

            int q1 = quadrant(x1, y1), q2 = quadrant(x2, y2);

            if (q1 != q2) return Integer.compare(q1, q2);

            long c = x1 * y2 - x2 * y1;

            if (c == 0) return Long.compare(x1 * x1 + y1 * y1, x2 * x2 + y2 * y2);
            return c < 0 ? 1 : -1;
        });

        StringBuilder sb = new StringBuilder();
        for (long[] p : positions) sb.append(p[0]).append(" ").append(p[1]).append("\n");

        System.out.println(sb);
    }

    static int quadrant(long x, long y) {

        if (x > 0 && y >= 0) return 1;
        if (x <= 0 && y > 0) return 2;
        if (x < 0) return 3;
        return 4;
    }
}