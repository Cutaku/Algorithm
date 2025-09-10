package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좀비떼가기관총진지에도오다니_19644 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ml = Integer.parseInt(st.nextToken()), mk = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());

        int[] damage = new int[l + 1];

        for (int i = 1; i <= l; i++) {
            damage[i] += damage[i - 1];

            int hp = Integer.parseInt(br.readLine());

            if (hp > damage[i] + mk) {
                if (c > 0) {
                    c--;
                } else {
                    System.out.println("NO");
                    return;
                }
            } else {
                damage[i] += mk;
                if (i + ml <= l) damage[i + ml] -= mk;
            }
        }

        System.out.println("YES");
    }
}