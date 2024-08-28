package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사과나무_19539 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int one = 0;
        int two = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(st.nextToken());

            one += tree % 2;
            two += tree / 2;
        }

        System.out.println(one > two || (one + 2 * two) % 3 > 0 ? "NO" : "YES");
    }
}