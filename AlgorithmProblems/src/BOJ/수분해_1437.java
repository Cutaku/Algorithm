package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수분해_1437 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int d = 10007;

        if (n < 4) {
            System.out.println(n);
            return;
        }

        int two;
        int three;

        if (n % 3 == 0) {
            two = 0;
            three = n / 3;
        } else if (n % 3 == 1) {
            two = 2;
            three = (n - 4) / 3;
        } else {
            two = 1;
            three = (n - 2) / 3;
        }

        int res = 1;

        for (int i = 0; i < two; i++) res = res * 2 % d;
        for (int i = 0; i < three; i++) res = res * 3 % d;

        System.out.println(res);
    }
}