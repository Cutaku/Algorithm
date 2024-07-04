package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] a = new int[31];
        int[] b = new int[31];

        int d = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                a[d++] = 2;
            } else if (c == '[') {
                a[d++] = 3;
            } else if (c == ')') {
                if (d == 0 || a[d - 1] != 2) {
                    System.out.println(0);
                    return;
                }

                b[d - 1] += Math.max(1, b[d]) * a[d - 1];
                b[d--] = 0;
            } else {
                if (d == 0 || a[d - 1] != 3) {
                    System.out.println(0);
                    return;
                }

                b[d - 1] += Math.max(1, b[d]) * a[d - 1];
                b[d--] = 0;
            }
        }

        System.out.println(d == 0 ? b[0] : 0);
    }
}