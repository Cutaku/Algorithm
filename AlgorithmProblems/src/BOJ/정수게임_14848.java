package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수게임_14848 {
    static long n;
    static int k;
    static int[] arr;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());

        ans = n;

        dfs(0, 0, 1);

        System.out.println(ans);
    }

    static void dfs(int d, int use, long l) {

        if (l > n) return;

        if (d == k) {
            if (use > 0) ans += (Integer.bitCount(use) % 2 == 0 ? 1 : -1) * (n / l);
            return;
        }

        dfs(d + 1, use, l);
        dfs(d + 1, use | (1 << d), lcm(l, arr[d]));
    }

    static long gcd(long a, long b) {

        while (b > 0) {
            long t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}