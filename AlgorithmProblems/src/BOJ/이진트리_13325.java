package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이진트리_13325 {
    static int n;
    static int[] weights;
    static long ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        weights = new int[1 << (n + 1)];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 2; i < 1 << (n + 1); i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;

        findLongest(1);

        System.out.println(ans);
    }

    static int findLongest(int node) {

        if (node >= 1 << n) return 0;

        int left = findLongest(node << 1);
        int right = findLongest(node << 1 | 1);
        int l = weights[node << 1];
        int r = weights[node << 1 | 1];

        ans += l + r + Math.abs(left + l - right - r);

        return Math.max(left + l, right + r);
    }
}