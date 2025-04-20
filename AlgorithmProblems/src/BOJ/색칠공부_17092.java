package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 색칠공부_17092 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()) - 1;
            long y = Long.parseLong(st.nextToken()) - 1;

            for (long j = Math.max(0, x - 2); j <= Math.min(h - 3, x); j++) {
                for (long k = Math.max(0, y - 2); k <= Math.min(w - 3, y); k++) {
                    long key = 1000000001L * j + k;

                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }

        long[] ans = new long[10];
        ans[0] = (long) (h - 2) * (w - 2);

        for (int v : map.values()) {
            ans[v]++;
        }

        for (int i = 1; i < 10; i++) ans[0] -= ans[i];
        for (int i = 0; i < 10; i++) System.out.println(ans[i]);
    }
}