package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GREAT_SWERC_PORTO_10529 {
    static long[] count;
    static boolean[] nonZero;
    static int c, ans;
    static int[] bitToInt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bitToInt = new int[513];
        for (int i = 0; i < 10; i++) bitToInt[1 << i] = i;

        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();

        count = new long[10];
        nonZero = new boolean[10];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int l = word.length();

            int d = i < n - 1 ? 1 : -1;

            for (int j = l - 1; j >= 0; j--) {
                char c = word.charAt(j);

                if (!map.containsKey(c)) map.put(c, map.size());

                count[map.get(c)] += d;
                if (j == 0) nonZero[map.get(c)] = true;

                d *= 10;
            }
        }

        c = map.size();
        ans = 0;

        dfs(0, (1 << 10) - 1, 0);

        System.out.println(ans);
    }

    static void dfs(int d, int b, long sum) {

        if (d == c) {
            if (sum == 0) ans++;

            return;
        }

        int bit = b;

        while (bit >= (1 << (10 - c))) {
            int q = bit & -bit;
            bit -= q;

            int i = bitToInt[q];
            if (nonZero[d] && i == 0) continue;

            dfs(d + 1, b - q, sum + count[d] * i);
        }
    }
}