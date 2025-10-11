package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타이핑_25215 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int l = str.length();
        int res = l;

        boolean[] isUpper = new boolean[l + 1];

        for (int i = 1; i <= l; i++) isUpper[i] = isUpper(str.charAt(i - 1));

        for (int i = 1; i < l; i++) {
            if (isUpper[i] == isUpper[i - 1]) continue;

            res++;

            if (isUpper[i] ^ isUpper[i + 1]) isUpper[i] = !isUpper[i];
        }

        if (isUpper[l - 1] ^ isUpper[l]) res++;

        System.out.println(res);
    }

    static boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}