package BOJ;

import java.util.Arrays;

public class 두수의합_9024 {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        int T = read();

        while (T-- > 0) {
            int n = read(), k = read();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = read();

            Arrays.sort(arr);

            int l = 0, r = n - 1;
            int min = Integer.MAX_VALUE;
            int cnt = 0;

            while (l < r) {
                int sum = arr[l] + arr[r];
                int d = Math.abs(sum - k);

                if (d < min) {
                    min = d;
                    cnt = 1;
                } else if (d == min) {
                    cnt++;
                }

                if (sum < k) {
                    l++;
                } else if (sum > k) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}