package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꽁꽁얼어붙은트리_34011 {
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) parent[i] = Integer.parseInt(st.nextToken()) - 1;

        int[] cnt = new int[n + 1];
        cnt[0] = 1;

        depth = new int[n];
        for (int i = 1; i < n; i++) cnt[depth(i)]++;

        int max = 0;

        boolean[] v = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (v[i]) continue;

            int sum = 0;
            for (int j = 1; i * j < n; j++) {
                v[i * j] = true;
                sum += cnt[i * j];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max + 1);
    }

    static int depth(int i) {

        if (i == 0) return 0;
        if (depth[i] != 0) return depth[i];

        return depth[i] = depth(parent[i]) + 1;
    }
}