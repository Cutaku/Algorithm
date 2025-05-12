package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 에어드롭_32177 {
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        root = new int[n + 1];
        for (int i = 1; i <= n; i++) root[i] = i;

        int[][] friends = new int[n + 1][];

        st = new StringTokenizer(br.readLine());
        friends[0] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), 0};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            friends[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            for (int j = 0; j < i; j++) {
                if (inRange(friends[i], friends[j], k, t)) {
                    int a = find(i);
                    int b = find(j);

                    root[Math.max(a, b)] = Math.min(a, b);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (find(i) == 0 && friends[i][3] == 1) ans.add(i);
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();

        for (int a : ans) {
            sb.append(a).append(" ");
        }

        System.out.println(ans.isEmpty() ? "0" : sb);
    }

    static boolean inRange(int[] a, int[] b, int k, int t) {

        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy <= k * k && Math.abs(a[2] - b[2]) <= t;
    }

    static int find(int a) {

        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}