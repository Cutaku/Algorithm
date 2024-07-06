package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열복원_1777 {
    static int n;
    static int[] fTree;
    static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        fTree = new int[n + 1];
        ans = new int[n];

        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[n - i] = Integer.parseInt(st.nextToken());
            fTree[i] = i & -i;
        }

        for (int i = 0; i < n; i++) {
            int c = seq[i] + 1;

            int idx = find(c);

            ans[n - idx] = n - i;
            update(idx);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ans[i]).append(" ");

        System.out.println(sb);
    }

    static void update(int idx) {

        while (idx <= n) {
            fTree[idx]--;
            idx += idx & -idx;
        }
    }

    static int sum(int idx) {

        int result = 0;

        while (idx > 0) {
            result += fTree[idx];
            idx -= idx & -idx;
        }

        return result;
    }

    static int find(int c) {

        if (fTree[1] == c) return 1;

        int s = 1, e = n;

        while (e - s > 1) {
            int m = (s + e) >> 1;

            if (sum(m) >= c) e = m;
            else s = m;
        }

        return e;
    }
}