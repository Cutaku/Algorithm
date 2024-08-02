package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나무심기_1280 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] count = new long[200001];
        long[] dist = new long[200001];

        long ans = 1;
        long s = 0;

        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(br.readLine()) + 1;

            long c1 = sum(count, d);
            long c2 = i - c1;

            long s1 = sum(dist, d);
            long s2 = s - s1;

            modify(count, d, 1);
            modify(dist, d, d);

            s += d;

            long cost = ((c1 - c2) * d + s2 - s1) % 1000000007;
            if (i > 0) ans = ans * cost % 1000000007;
        }

        System.out.println(ans);
    }

    static void modify(long[] tree, int i, int d) {

        while (i <= 200000) {
            tree[i] += d;
            i += i & -i;
        }
    }

    static long sum(long[] tree, int i) {

        long res = 0;

        while (i > 0) {
            res += tree[i];
            i -= i & -i;
        }

        return res;
    }
}