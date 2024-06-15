package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수이어쓰기2_1790 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()) - 1;

        int a = 1;
        long b = 9;

        long m = 1;

        while (k >= a * b) {
            k -= a * b;
            m += b;
            a++;
            b *= 10;
        }

        m += k / a;

        System.out.println(n < m ? "-1" : String.valueOf(m).charAt(k % a));
    }
}