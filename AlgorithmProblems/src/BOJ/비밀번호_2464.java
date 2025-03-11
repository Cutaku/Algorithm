package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호_2464 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());

        long b = 1;
        int cnt = 0;

        while (a >= b) {
            if ((a & b) > 0) cnt++;
            if ((a & b) == 0 && (a & (b << 1)) > 0) break;

            b <<= 1;
        }

        if (b > a) {
            System.out.print("0 ");
        } else {

            long min = 0;

            for (int i = 0; i <= cnt; i++) {
                min |= b >> i;
            }

            b <<= 2;

            while (b <= a) {
                min |= b & a;
                b <<= 1;
            }

            System.out.print(min);
            System.out.print(" ");
        }

        b = 1;
        cnt = 0;

        while (a >= b) {
            if ((a & b) > 0) {
                if ((a & (b << 1)) == 0) break;

                cnt++;
            }

            b <<= 1;
        }

        long max = b << 1;
        for (int i = 0; i < cnt; i++) max |= 1L << i;

        b <<= 2;

        while (b <= a) {
            max |= b & a;
            b <<= 1;
        }

        System.out.print(max);
    }
}