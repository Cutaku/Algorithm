package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 결전의금요일_25194 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] week = new boolean[7];
        week[0] = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            boolean[] tmp = new boolean[7];

            for (int j = 0; j < 7; j++) {
                if (week[j]) {
                    tmp[j] = true;
                    tmp[(j + a) % 7] = true;
                }
            }

            week = tmp;
        }

        System.out.println(week[4] ? "YES" : "NO");
    }
}