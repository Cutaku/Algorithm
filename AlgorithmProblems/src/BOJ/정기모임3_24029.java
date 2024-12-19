package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 정기모임3_24029 {
    static List<Integer>[] adj;
    static int[][][] longest;
    static boolean[] v;
    static int[] dp;
    static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj[a].add(b);
            adj[b].add(a);
        }

        longest = new int[n][2][2];
        v =  new boolean[n];

        findLongest(0, 0);

        dp = new int[n + 1];
        v = new boolean[n];
        idx = 0;

        count(0, 0);

        dp[0] /= 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sb.append(i <= dp[0] ? "2\n" : "1\n");
            } else {
                while (idx > 1 && dp[idx] < i) idx--;

                sb.append(idx).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int findLongest(int i, int d) {

        v[i] = true;

        int[][] arr = longest[i];

        for (int child : adj[i]) {
            if (v[child]) continue;

            int l = findLongest(child, d + 1) + 1;

            if (l > arr[0][1]) {
                arr[1][0] = arr[0][0];
                arr[1][1] = arr[0][1];
                arr[0][0] = child;
                arr[0][1] = l;
            } else if (l > arr[1][1]) {
                arr[1][0] = child;
                arr[1][1] = l;
            }
        }

        return arr[0][1];
    }

    static int count(int i, int sum) {

        v[i] = true;

        List<Integer> list = new ArrayList<>();
        list.add(sum * 2);

        int max = 0;

        for (int child : adj[i]) {
            if (v[child]) continue;

            int l = 0;

            for (int j = 0; j < 2; j++) {
                if (longest[i][j][0] != child) l = Math.max(l, longest[i][j][1]);
            }

            int d = count(child, Math.max(l, sum) + 1) + 1;

            list.add(d * 2);
            max = Math.max(max, d);
        }

        idx = Math.max(idx, list.size());

        list.sort(Collections.reverseOrder());

        dp[0] = Math.max(dp[0], list.size() > 1 ? list.get(0) + list.get(1) : list.get(0));

        for (int j = 0; j < list.size(); j++) {
            dp[j + 1] = Math.max(dp[j + 1], list.get(j));
        }

        return max;
    }
}