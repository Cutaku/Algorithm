package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내이진트리를돌려줘_18132 {
    static long[] memo;
    static long d = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memo = new long[5001];

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(count(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.println(sb);
    }

    static long count(int n) {

        if (n < 1) return 1;
        if (memo[n] > 0) return memo[n];

        long res = 0;

        for (int i = 0; i <= n; i++) {
            res = (res + count(i - 1) * count(n - i - 1)) % d;
        }

        return res;
    }
}