package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 실행시간_22947 {
    static int n, m, k;
    static int[] time;
    static List<Integer>[] pre;
    static int[] finTime;
    static int last;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        time = new int[n];
        pre = new List[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            pre[i] = new ArrayList<>();
        }

        boolean[] start = new boolean[n];
        last = n * (n - 1) / 2;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            if (!start[s]) {
                start[s] = true;
                last -= s;
            }

            pre[e].add(s);
        }

        ans = Integer.MAX_VALUE;

        dfs(0, 1);

        System.out.println(ans);
    }

    static void dfs(int d, int l) {

        if (d == k) {
            ans = Math.min(ans, getTotalTime());
            return;
        }

        for (int i = l; i < n; i++) {
            if (i == last) continue;

            int tmp = time[i];

            time[i] = 0;
            dfs(d + 1, i + 1);
            time[i] = tmp;
        }
    }

    static int getTotalTime() {

        finTime = new int[n];

        return finTime(last);
    }

    static int finTime(int a) {

        if (finTime[a] > 0) return finTime[a];

        int max = 0;

        for (int b : pre[a]) {
            max = Math.max(max, finTime(b));
        }

        return finTime[a] = time[a] + max;
    }
}