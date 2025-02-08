package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도도의음식준비_22953 {
    static int n, k, c;
    static int[] cooks;
    static long min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cooks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cooks[i] = Integer.parseInt(st.nextToken());

        min = Long.MAX_VALUE;

        dfs(0);

        System.out.println(min);
    }

    static void dfs(int d) {

        if (d == c) {
            long s = 0, e = (long) k * 1000000;

            while (e - s > 1) {
                long m = (s + e) / 2;
                long sum = 0;

                for (int i = 0; i < n; i++) {
                    sum += m / cooks[i];
                }

                if (sum >= k) e = m;
                else s = m;
            }

            min = Math.min(min, e);

            return;
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += cooks[i];

            if (cooks[i] == 1) continue;

            cooks[i]--;
            dfs(d + 1);
            cooks[i]++;
        }

        if (cnt == n) min = (k + n - 1) / n;
    }
}