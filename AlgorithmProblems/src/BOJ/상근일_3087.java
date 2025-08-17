package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근일_3087 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()), k = Long.parseLong(st.nextToken());

        if (k >= n) {
            System.out.println(2 * n - 1);
            return;
        }

        long left = n * n - k * (k + 1);

        System.out.println((left + k - 1) / k + 2 * k);
    }
}