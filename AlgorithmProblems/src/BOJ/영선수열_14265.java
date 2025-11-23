package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영선수열_14265 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());

        if (k == 0) {
            System.out.println(b - a + 1);
            return;
        }

        long c = k % 2 == 0 ? 2 : 1;
        long ans = 0;

        while (k <= b) {
            if (a < k + c) {
                ans += Math.min(b + 1, k + c) - Math.max(a, k);
            }

            k <<= 1;
            c <<= 1;
        }

        System.out.println(ans);
    }
}