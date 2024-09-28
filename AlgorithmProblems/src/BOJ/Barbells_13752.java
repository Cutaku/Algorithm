package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Barbells_13752 {
    static int b, p;
    static int[] bars, plates;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        bars = new int[b];
        plates = new int[p];

        for (int i = 0; i < b; i++) bars[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) plates[i] = Integer.parseInt(br.readLine());

        set = new HashSet<>();

        dfs(0, 0, 0, 0, 0);

        TreeSet<Integer> ans = new TreeSet<>();

        for (int i = 0; i < b; i++) {
            for (int plate : set) {
                ans.add(bars[i] + plate);
            }
        }

        while (!ans.isEmpty()) {
            sb.append(ans.pollFirst()).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int d, int left, int right, int lSum, int rSum) {

        if (lSum == rSum) set.add(lSum + rSum);

        if (d == p || left < right) return;

        int i = 1 << (p - d - 1);

        dfs(d + 1, left | i, right, lSum + plates[p - d - 1], rSum);
        dfs(d + 1, left, right | i, lSum, rSum + plates[p - d - 1]);
        dfs(d + 1, left, right, lSum, rSum);
    }
}