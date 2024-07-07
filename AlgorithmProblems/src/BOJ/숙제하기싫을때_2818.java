package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숙제하기싫을때_2818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long r = Long.parseLong(st.nextToken()), c =  Long.parseLong(st.nextToken());

        long ans = 0;

        ans += (c / 4) * 14 * r;
        c %= 4;

        if (c == 1) {
            int[] left = {0, 1, 6, 12};
            ans += (r / 4) * 14 + left[(int) r % 4];
        } else if (c == 2) {
            int[] left = {0, 5, 11, 19, 28, 36};
            ans += (r / 6) * 42 + left[(int) r % 6];
        } else if (c == 3) {
            ans += r * 11;
        }

        System.out.println(ans);
    }
}