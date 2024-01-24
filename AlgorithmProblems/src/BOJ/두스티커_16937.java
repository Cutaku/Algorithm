package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두스티커_16937 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] hw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int h = hw[0], w = hw[1];

        int n = Integer.parseInt(br.readLine());

        int[][] stickers = new int[n][];
        for (int i = 0; i < n; i++) {
            stickers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        }

        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            int r1 = stickers[i][0];
            int c1 = stickers[i][1];

            if (h < r1 || w < c1) continue;

            for (int j = i + 1; j < n; j++) {
                int r2 = stickers[j][0];
                int c2 = stickers[j][1];

                if (h < r2 || w < c2) continue;

                if (pos(h, w, r1, c1, r2, c2)) {
                    max = Math.max(max, r1 * c1 + r2 * c2);
                }
            }
        }

        System.out.println(max);
    }

    static boolean pos(int h, int w, int r1, int c1, int r2, int c2) {

        int r = r1 + r2;
        int c = Math.max(c1, c2);
        if (h >= Math.min(r, c) && w >= Math.max(r, c)) return true;

        r = r1 + c2;
        c = Math.max(r2, c1);
        if (h >= Math.min(r, c) && w >= Math.max(r, c)) return true;

        r = r2 + c1;
        c = Math.max(r1, c2);
        if (h >= Math.min(r, c) && w >= Math.max(r, c)) return true;

        r = c1 + c2;
        c = Math.max(r1, r2);
        return h >= Math.min(r, c) && w >= Math.max(r, c);
    }
}