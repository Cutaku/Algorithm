package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전교환_1532 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int g1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int g2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int ans = 0;

        if (g1 < g2) {
            s1 -= (g2 - g1) * 11;
            ans += g2 - g1;
            g1 = g2;
        }

        if (b1 < b2) {
            s1 -= (b2 - b1 + 8) / 9;
            ans += (b2 - b1 + 8) / 9;
            b1 = b2;
        }

        if (s1 < s2 && g1 > g2) {
            int c = Math.min(g1 - g2, (s2 - s1 + 8) / 9);
            s1 += c * 9;
            ans += c;
        }

        if (s1 < s2 && b1 > b2) {
            int c = Math.min((b1 - b2) / 11, s2 - s1);
            s1 += c;
            ans += c;
        }

        System.out.println(s1 >= s2 ? ans : -1);
    }
}