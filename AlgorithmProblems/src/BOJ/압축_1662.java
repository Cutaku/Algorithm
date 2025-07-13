package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 압축_1662 {
    static String S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        System.out.println(length(0, S.length() - 1));
    }

    static int length(int i, int j) {

        if (i > j) return 0;

        int res = 0;

        while (i < j && isNumber(i)) {
            res++;
            i++;
        }

        if (i == j) return res + 1;

        int c = 1;
        int k = i;

        while (c > 0) {
            if (S.charAt(++k) == '(') c++;
            else if (S.charAt(k) == ')') c--;
        }

        return res - 1 + (S.charAt(i - 1) - '0') * length(i + 1, k - 1) + length(k + 1, j);
    }

    static boolean isNumber(int i) {

        return S.charAt(i) >= '0' && S.charAt(i) <= '9';
    }
}