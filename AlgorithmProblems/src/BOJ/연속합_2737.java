package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속합_2737 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int r = 1;
            int c = 0;
            int i = 2;

            while (r < n) {
                if ((n - r) % i == 0) c++;

                r += i++;
            }

            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}