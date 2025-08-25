package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리만들기_12947 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = n, c = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            if (Integer.parseInt(st.nextToken()) > 1) {
                c++;
            } else {
                max = Math.max(max, n - i + 2 * c + 1);
                c = 0;
            }
        }

        if (c > 0) max = Math.max(max, 2 * c);

        System.out.println(max);
    }
}