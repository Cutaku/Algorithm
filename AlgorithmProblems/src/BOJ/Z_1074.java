package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = 1 << (n - 1);

        int ans = 0;

        while (m > 0) {
            int d = 2 * (r / m) + (c / m);

            ans += d * m * m;

            r %= m;
            c %= m;
            m /= 2;
        }

        System.out.println(ans);
    }
}