package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 샤워실바닥깔기_Large_14601 {
    static int k, n;
    static int[][] ground;
    static int num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        n = 1 << k;
        ground = new int[n][n];
        num = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken()) - 1;
        int r = n - Integer.parseInt(st.nextToken());

        ground[r][c] = -1;

        dnc(0, 0, n, r, c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ground[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dnc(int i, int j, int l, int r, int c) {

        if (l == 1) return;

        l /= 2;

        int p = 2 * (r / l) + c / l;

        int t = num++;

        for (int k = 0; k < 4; k++) {
            int b1 = k / 2, b2 = k % 2;

            if (k == p) {
                dnc(i + l * b1, j + l * b2, l, r % l, c % l);
            } else {
                ground[i + l - 1 + b1][j + l - 1 + b2] = t;
                dnc(i + l * b1, j + l * b2, l, (l + b1 - 1) % l, (l + b2 - 1) % l);
            }
        }
    }
}