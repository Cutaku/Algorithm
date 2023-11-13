package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 선물전달_1947 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int d = 1000000000;

        long[] count = new long[n + 1];

        count[0] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = (count[i - 1] + count[i - 2]) * (i - 1);
            count[i] %= d;
        }

        System.out.println(count[n]);
    }
}