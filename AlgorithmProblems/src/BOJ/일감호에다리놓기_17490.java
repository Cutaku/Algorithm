package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일감호에다리놓기_17490 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        if (m < 2) {
            System.out.println("YES");
            return;
        }

        st = new StringTokenizer(br.readLine());

        int[] count = new int[n];
        for (int i = 0; i < n; i++) count[i] = Integer.parseInt(st.nextToken());

        boolean[] disconnected = new boolean[n];

        int last = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (Math.abs(a - b) == 1) a = Math.min(a, b);
            else a = Math.max(a, b);

            disconnected[a] = true;

            last = Math.max(last, a);
        }

        int min = 1000000;

        for (int j = last + 1; j < n; j++) {
            min = Math.min(min, count[j]);
        }

        int idx = 0;

        while (idx <= last) {
            min = Math.min(min, count[idx]);

            if (disconnected[idx++]) {
                k -= min;
                min = 1000000;
            }
        }

        System.out.println(k >= 0 ? "YES" : "NO");
    }
}