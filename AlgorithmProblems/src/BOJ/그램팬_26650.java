package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그램팬_26650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        long ans = 0;

        int idx = 0;

        while (idx < s.length()) {
            if (s.charAt(idx) != 'A') {
                idx++;
                continue;
            }

            idx++;
            long a = 1;
            long z = 0;

            while (idx < s.length() && (s.charAt(idx - 1) == s.charAt(idx) || s.charAt(idx - 1) + 1== s.charAt(idx))) {
                if (s.charAt(idx) == 'A') a++;
                if (s.charAt(idx) == 'Z') z++;

                idx++;
            }

            ans += a * z;
        }

        System.out.println(ans);
    }
}