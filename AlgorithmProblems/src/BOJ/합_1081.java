package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합_1081 {
    static int[] preSum = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long l = Long.parseLong(st.nextToken()), u = Long.parseLong(st.nextToken());

        System.out.println(sum(u) - sum(l - 1));
    }

    static long sum(long a) {

        long res = 0;
        long d = 1;

        while (d <= a) {
            int x = (int) (a / d % 10);
            long y = a % d;
            long z = a / d / 10;

            res += 45 * d * z + preSum[Math.max(x - 1, 0)] * d + (y + 1) * x;

            d *= 10;
        }

        return res;
    }
}