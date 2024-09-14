package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아기홍윤_24023 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int res = 0;
        int s = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if ((a | k) == k) {
                res |= a;

                if (res == k) {
                    System.out.println((s + 1) + " " + (i + 1));
                    return;
                }
            } else {
                s = i + 1;
                res = 0;
            }
        }

        System.out.println(-1);
    }
}