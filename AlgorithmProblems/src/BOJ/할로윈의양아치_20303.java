package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 할로윈의양아치_20303 {
    static int[] roots;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        roots = new int[n];
        int[] counts = new int[n];
        int[] candies = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            roots[i] = i;
            counts[i] = 1;
            candies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = find(Integer.parseInt(st.nextToken()) - 1);
            int r2 = find(Integer.parseInt(st.nextToken()) - 1);

            if (r1 == r2) {
                continue;
            } else if (r1 < r2) {
                int t = r1;
                r1 = r2;
                r2 = t;
            }

            roots[r1] = r2;
            counts[r2] += counts[r1];
            candies[r2] += candies[r1];
        }

        List<int[]> list = new ArrayList<>();

        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            int r = find(i);

            if (used[r]) continue;
            used[r] = true;

            list.add(new int[] {counts[r], candies[r]});
        }

        int[] dp = new int[k];

        for (int i = 0; i < list.size(); i++) {
            int p = list.get(i)[0];
            int v = list.get(i)[1];

            for (int j = k - 1; j >= p ; j--) {
                dp[j] = Math.max(dp[j], dp[j - p] + v);
            }
        }

        System.out.println(dp[k - 1]);
    }

    static int find(int a) {

        if (a == roots[a]) return a;
        return roots[a] = find(roots[a]);
    }
}
