package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍_bit_1799 {
    static int n;
    static int[] odd;
    static int[] even;
    static int oMax, eMax;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        odd = new int[n];
        even = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                odd[i] <<= 1;
                even[i] <<= 1;

                if (Integer.parseInt(st.nextToken()) == 0) continue;

                if ((i + j) % 2 == 1) odd[i] |= 1;
                else even[i] |= 1;
            }
        }

        oMax = 0;
        eMax = 0;

        dfs(odd[0], 0, 0, 0, 0, true);
        dfs(even[0], 0, 0, 0, 0, false);

        System.out.println(eMax + oMax);
    }

    static void dfs(int able, int d1, int d2, int row, int count, boolean isOdd) {

        if (row == n - 1) {
            count += Integer.bitCount(able);

            if (isOdd) oMax = Math.max(oMax, count);
            else eMax = Math.max(eMax, count);

            return;
        }

        if (able == 0) {
            if (isOdd) able = odd[row + 1];
            else able = even[row + 1];

            d1 >>= 1;
            d2 <<= 1;

            able = able & ~(d1 | d2);

            dfs(able, d1, d2, row + 1, count, isOdd);

            return;
        }

        int p = able & -able;
        able -= p;

        dfs(able, d1 | p, d2 | p, row, count + 1, isOdd);
        dfs(able, d1, d2, row, count, isOdd);
    }
}