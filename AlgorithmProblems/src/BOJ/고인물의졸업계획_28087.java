package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고인물의졸업계획_28087 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int sum = 0;
        int cnt = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= m; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 2 * n) {
            } else if (x >= n) {
                System.out.println(1);
                System.out.println(i);
                return;
            } else {
                sum += x;
                cnt++;
                sb.append(i).append("\n");

                if (sum >= n) break;
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}