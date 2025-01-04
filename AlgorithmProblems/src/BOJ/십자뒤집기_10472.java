package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 십자뒤집기_10472 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());

        int[] bit = new int[257];
        bit[1] = 11;
        bit[2] = 23;
        bit[4] = 38;
        bit[8] = 89;
        bit[16] = 186;
        bit[32] = 308;
        bit[64] = 200;
        bit[128] = 464;
        bit[256] = 416;

        while (p-- > 0) {
            int n = 0;

            for (int i = 0; i < 3; i++) {
                String line = br.readLine();

                for (int j = 0; j < 3; j++) {
                    n <<= 1;
                    n |= line.charAt(j) == '*' ? 1 : 0;
                }
            }

            int min = 10;

            for (int i = 0; i < 512; i++) {
                int m = n;
                int cnt = 0;
                int b = i;

                while (b > 0) {
                    cnt++;

                    int q = b & -b;
                    b -= q;

                    m ^= bit[q];
                }

                if (m == 0) min = Math.min(min, cnt);
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}