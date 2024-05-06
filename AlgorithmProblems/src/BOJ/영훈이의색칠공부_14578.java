package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영훈이의색칠공부_14578 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 1000000007;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long[] a = new long[n];
        long[] b = new long[n];

        a[0] = 1;
        a[1] = 2;
        b[1] = 1;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] * (i + 1) % d;
            b[i] = (b[i - 2] + b[i - 1]) * i % d;
        }

        System.out.println(a[n - 1] * b[n - 1] % d);
    }
}