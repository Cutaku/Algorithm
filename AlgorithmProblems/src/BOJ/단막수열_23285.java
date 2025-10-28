package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단막수열_23285 {
    static int n;
    static int[] cnt;
    static boolean[] used;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n - 2];
        cnt = new int[n - 1];
        used = new boolean[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
            cnt[arr[i]]++;
        }

        int[][] ans = new int[n - 1][];

        for (int i = 0; i < n - 2; i++) {
            int idx = findMin();

            cnt[arr[i]]--;
            ans[i] = new int[]{Math.min(idx, arr[i]) + 1, Math.max(idx, arr[i]) + 1};
        }

        ans[n - 2] = new int[]{findMin() + 1, n};

        Arrays.sort(ans, (a, b) -> {
            if  (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            sb.append(ans[i][0]).append(" ").append(ans[i][1]).append("\n");
        }

        System.out.println(sb);
    }

    static int findMin() {

        for (int i = 0; i < n - 1; i++) {
            if (used[i] || cnt[i] > 0) continue;

            used[i] = true;
            return i;
        }

        return n - 1;
    }
}