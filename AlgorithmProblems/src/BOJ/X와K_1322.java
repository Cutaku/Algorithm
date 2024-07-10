package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class X와K_1322 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long ans = 0;

        int b = 0;

        while (x > 0) {
            if (x % 2 == 0) {
                ans |= (k % 2) << b;
                k >>= 1;
            }

            x >>= 1;
            b++;
        }

        ans += k << b;

        System.out.println(ans);
    }
}