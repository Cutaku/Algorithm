package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사와칠_2877 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        int n = k - Integer.highestOneBit(k + 1) + 1;

        StringBuilder sb = new StringBuilder();

        k++;

        while (k > 1) {
            sb.append(n % 2 == 0 ? "4" : "7");
            k /= 2;
            n /= 2;
        }

        System.out.println(sb.reverse());
    }
}