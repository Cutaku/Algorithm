package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호코드_2011 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();

        int l = password.length();

        for (int i = 0; i < l; i++) {
            int part = password.charAt(0) - '0';
            if (i > 0) part = Integer.parseInt(password.substring(i - 1, i + 1));

            if (part % 10 == 0 && (part == 0 || part >= 30)) {
                System.out.println(0);
                return;
            }
        }

        int[] count = new int[l + 1];
        count[0] = 1;
        count[1] = 1;

        for (int i = 1; i < l; i++) {
            if (password.charAt(i) != '0') {
                count[i + 1] = count[i];
            }

            if (password.charAt(i - 1) != '0' && Integer.parseInt(password.substring(i - 1, i + 1)) <= 26) {
                count[i + 1] += count[i - 1];
                count[i + 1] %= 1000000;
            }
        }

        System.out.println(count[l]);
    }
}