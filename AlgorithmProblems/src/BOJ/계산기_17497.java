package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계산기_17497 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        boolean isOdd = n % 2 == 1;

        n >>= 1;
        String b = Long.toBinaryString(n);
        int l = b.length();

        int ans = l + Long.bitCount(n) - 1;

        StringBuilder sb = new StringBuilder();

        if (n > 0) sb.append("[+] ");

        for (int i = 1; i < l; i++) {
            sb.append("[*] ");

            if (b.charAt(i) == '1') sb.append("[+] ");
        }

        if (isOdd) {
            ans += 3;
            sb.append("[*] [+] [/]");
        }

        System.out.println(ans);
        System.out.println(sb);
    }
}