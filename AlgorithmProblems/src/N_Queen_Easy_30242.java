import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N_Queen_Easy_30242 {
    static int n;
    static long m;
    static int[] ans;
    static boolean[] v;
    static Map<Long, Integer> toIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = (1L << n) - 1;
        m <<= 20;

        ans = new int[n];
        v = new boolean[n];

        toIdx = new HashMap<>();
        for (int i = 0; i < n; i++) toIdx.put(1L << (i + 20), i + 1);

        long c = 0;
        long d1 = 0;
        long d2 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());

            if (ans[i] == 0) continue;

            v[i] = true;

            int a = ans[i] - 1 + 20;

            c |= 1L << a;
            d1 |= 1L << (a + i);
            d2 |= 1L << (a - i);
        }

        dfs(0, c, d1, d2);

        System.out.println(-1);
    }

    static void dfs(int r, long c, long d1, long d2) {

        if (r == n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) sb.append(ans[i]).append(" ");

            System.out.println(sb);

            System.exit(0);
        }

        if (v[r]) {
            dfs(r + 1, c, d1 >> 1, d2 << 1);
            return;
        }

        long able = m & ~(c | d1 | d2);

        while (able > 0) {
            long b = able & -able;
            able -= b;

            ans[r] = toIdx.get(b);
            dfs(r + 1, c | b, (d1 | b) >> 1, (d2 | b) << 1);
        }
    }
}