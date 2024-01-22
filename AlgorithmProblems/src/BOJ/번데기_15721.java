package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 번데기_15721 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine()) - 1;
        int b = Integer.parseInt(br.readLine());

        int s = 4;

        int n = 0;

        while (t >= s) {
            t -= s;
            n += s * 2;
            s++;
        }

        if (t < 2) {
            n += t * 2 + b;
        } else {
            t -= 2;
            n += 4 + t;
            if (b == 1) n += s - 2;
        }

        System.out.println(n % a);
    }
}