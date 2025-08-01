package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박스채우기_1493 {
    static long[] need;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken()), w = Long.parseLong(st.nextToken()), h = Long.parseLong(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        long[] cubes = new long[20];
        need = new long[20];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cubes[Integer.parseInt(st.nextToken())] = Long.parseLong(st.nextToken());
        }

        fill(l, w, h);

        long ans = 0;

        for (int i = 19; i >= 0; i--) {
            if (need[i] > 0) {
                ans += Math.min(need[i], cubes[i]);
                if (i > 0) need[i - 1] += Math.max(0, need[i] - cubes[i]) << 3;
            }
        }

        System.out.println(need[0] - cubes[0] > 0 ? -1 : ans);
    }

    static void fill(long l, long w, long h) {

        if (l == 0 || w == 0 || h == 0) return;

        for (int i = 19; i >= 0; i--) {
            long r = 1L << i;

            if (l >= r && w >= r && h >= r) {
                need[i] += (l / r) * (w / r) * (h / r);

                fill(l, w, h % r);
                fill(l % r, w, r * (h / r));
                fill(r * (l / r), w % r, r * (h / r));

                return;
            }
        }
    }
}