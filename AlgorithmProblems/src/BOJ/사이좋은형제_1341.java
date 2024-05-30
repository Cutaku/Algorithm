package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이좋은형제_1341 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());

        long n = 1;

        for (int i = 0; i < 60; i++) {
            if (n % b == 0) {
                StringBuilder sb = new StringBuilder();

                a *= n / b;
                n = (n + 1) >> 1;

                while (n > 0) {
                    if (a >= n) {
                        sb.append("*");
                        a -= n;
                    } else {
                        sb.append("-");
                    }

                    n >>= 1;
                }

                System.out.println(sb);
                return;
            }

            n = n << 1 | 1;
        }

        System.out.println(-1);
    }
}