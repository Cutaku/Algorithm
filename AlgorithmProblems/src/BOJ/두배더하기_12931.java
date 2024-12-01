package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두배더하기_12931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());

            int m = 0;

            while (b > 0) {
                if (b % 2 == 0) {
                    b >>= 1;
                    m++;
                } else {
                    b--;
                    count++;
                }
            }

            max = Math.max(max, m);
        }

        System.out.println(count + max);
    }
}