package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 두더지찾기_32633 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        long lcm = 1L;
        List<Long> zeros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(A.nextToken());

            if (B.nextToken().equals("1")) {
                lcm = lcm(lcm, a);

                if (lcm > l) {
                    System.out.println(-1);
                    return;
                }
            } else {
                zeros.add(a);
            }
        }

        for (long a : zeros) {
            if (lcm % a == 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(lcm);
    }

    static long gcd(long a,long b) {

        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a,long b) {

        return a /  gcd(a, b) * b;
    }
}