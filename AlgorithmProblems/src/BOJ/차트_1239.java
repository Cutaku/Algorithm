package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차트_1239 {
    static int n;
    static int[] cnt;
    static int sum, half;
    static boolean[] v;
    static int max;
    static int[] toInt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cnt = new int[n];
        sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
            sum += cnt[i];
        }

        if (sum % 2 == 1) {
            System.out.println(0);
            return;
        }

        half = sum / 2;
        v = new boolean[sum + 1];
        max = 0;

        v[0] = true;
        v[cnt[0]] = true;

        toInt = new int[(1 << (n - 1)) + 1];
        for (int i = 0; i < n; i++) toInt[1 << i] = i;

        dfs(1, 0, cnt[0], (1 << n) - 2);

        System.out.println(max);
    }

    static void dfs(int d, int c, int s, int b) {

        if (d == n) {
            max = Math.max(max, c);
            return;
        }

        int l = b;

        while (l > 0) {
            int r = l & -l;
            l -= r;

            int i = toInt[r];
            int num = cnt[i];

            v[s + num] = true;

            if (s + num > half && v[s + num - half]) dfs(d + 1, c + 1, s + num, b - r);
            else dfs(d + 1, c, s + num, b - r);

            v[s + num] = false;
        }
    }
}