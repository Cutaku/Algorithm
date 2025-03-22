package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자파티_27738 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        long m = n % f;
        long ans = 0;

        for (long i = n - m + 1; i <= n; i++) {
            if (i % a == 0) ans += i;
            if (i % b == 0) ans %= i;
            if (i % c == 0) ans &= i;
            if (i % d == 0) ans ^= i;
            if (i % e == 0) ans |= i;
        }

        System.out.println(ans);
    }
}