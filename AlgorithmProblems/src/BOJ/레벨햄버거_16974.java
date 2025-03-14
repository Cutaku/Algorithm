package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 레벨햄버거_16974 {
    static long[] heights;

    public static void main(String[] args) throws IOException {

        heights = new long[51];

        heights[0] = 1;
        for (int i = 1; i < 51; i++) heights[i] = 2 * heights[i - 1] + 3;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        System.out.println(count(n, x));
    }

    static long count(int n, long x) {

        if (x < 2) {
           if (n == 0) return x;
           else return 0;
        }

        long h = heights[n];

        if (h <= x) return h / 2 + 1;

        long res = x > h / 2 ? 1 + count(n - 1, x - h / 2 - 1): 0;

        return res + count(n - 1, x - 1);
    }
}