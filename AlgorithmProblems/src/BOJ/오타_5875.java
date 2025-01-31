package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오타_5875 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        int c = 0, l = 0, r = 0;
        boolean flag = true;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                c++;
                l++;
            } else {
                if (flag) r++;
                if (--c < 0) flag = false;
            }

            if (c < 2) l = 0;
        }

        System.out.println(c == 2 ? l : c == -2 ? r : 0);
    }
}