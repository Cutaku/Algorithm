package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HouseNumbers_16691 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        int x = m + 1;
        int n = x + 1;

        long front = m;
        long back = n;

        while (front != back) {
            if (back < front) {
                back += ++n;
            } else {
                front += x++;
                back -= x;
            }
        }

        System.out.println(m + " " + x + " " + n);
    }
}