package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식평론가_1188 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        System.out.println(m - gcd(n, m));
    }

    static int gcd(int a, int b) {

        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}