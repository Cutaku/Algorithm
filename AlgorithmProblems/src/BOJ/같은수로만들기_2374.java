package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 같은수로만들기_2374 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] stack = new long[2];
        stack[0] = Long.parseLong(br.readLine());

        long ans = 0;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            long a = Long.parseLong(br.readLine());

            if (flag) {
                if (a >= stack[0]) {
                    ans += a - stack[1];
                    flag = false;
                    stack[0] = a;
                } else if (a > stack[1]) {
                    ans += a - stack[1];
                    stack[1] = a;
                } else {
                    stack[1] = a;
                }
            } else {
                if (a >= stack[0]) {
                    ans += a - stack[0];
                    stack[0] = a;
                } else {
                    stack[1] = a;
                    flag = true;
                }
            }
        }

        if (flag) ans += stack[0] - stack[1];

        System.out.println(ans);
    }
}