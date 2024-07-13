package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열복사_2195 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int l = 0;

        int ans = 0;

        while (l < p.length()) {
            int max = 0;

            for (int i = 0; i < s.length(); i++) {
                if (p.charAt(l) == s.charAt(i)) {
                    int count = 1;

                    while (l + count < p.length() && i + count < s.length() && p.charAt(l + count) == s.charAt(i + count)) {
                        count++;
                    }

                    max = Math.max(max, count);
                }
            }

            l += max;
            ans++;
        }

        System.out.println(ans);
    }
}