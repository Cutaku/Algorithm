package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시간을돌리고싶어_32347 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        boolean[] power = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) power[i] = st.nextToken().charAt(0) == '1';

        int[] right = new int[n];
        right[n - 1] = n - 1;

        int s = 0;

        int r = n - 1;
        for (int i = n - 2; i > 0; i--) {
            if (power[i]) {
                s = Math.max(s, r - i);
                r = i;
            }

            right[i] = r;
        }

        s = Math.max(s, r);

        if (s == n - 1) {
            System.out.println(n - 1);
            return;
        }

        if (check(right, s, k)) {
            System.out.println(s);
            return;
        }

        int e = n - 1;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (check(right, m, k)) e = m;
            else s = m;
        }

        System.out.println(e);
    }

    static boolean check(int[] right, int t, int k) {

        int cnt = 0;
        int idx = right.length - 1;

        while (idx > 0) {
            idx = Math.max(0, idx - t);
            idx = right[idx];

            cnt++;
        }

        return cnt <= k;
    }
}