package BOJ;

import java.util.Arrays;
import java.util.Comparator;

public class 극적인승리_33543 {
    public static void main(String[] args) throws Exception {


        int a = read(), b = read();
        int d = a - b;

        if (d < 0) {
            System.out.println("1 1");
            return;
        }

        int n = read();

        int[][] left = new int[n + 1][];
        int[][] right = new int[n + 1][];

        left[0] = new int[]{-1, 0};
        right[0] = new int[]{-1, 0};

        for (int i = 1; i <= n; i++) {
            left[i] = new int[]{i, read()};
            right[i] = new int[]{i, read()};
        }

        Arrays.sort(right, Comparator.comparingInt(x -> x[1]));

        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];

        for (int i = 0; i <= n; i++) {
            int t = d - left[i][1];

            if (t < 0) {
                if (min > -t) {
                    min = -t;
                    ans[0] = left[i][0];
                    ans[1] = -1;
                }

                continue;
            }

            if (right[n][1] <= t) continue;

            int l = 0, r = n;

            while (r - l > 1) {
                int m = (l + r) >> 1;

                if (right[m][1] > t) r = m;
                else l = m;
            }

            if (left[i][0] == right[r][0]) r++;

            if (r > n) continue;

            if (left[i][1] + right[r][1] - d < min) {
                min = left[i][1] + right[r][1] - d;
                ans[0] = left[i][0];
                ans[1] = right[r][0];
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("NO");
        } else {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}