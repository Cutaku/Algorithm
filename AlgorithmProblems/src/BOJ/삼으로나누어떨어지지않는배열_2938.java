package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 삼으로나누어떨어지지않는배열_2938 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }

        List<Integer>[] lists = new List[3];
        for (int i = 0; i < 3; i++) lists[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            lists[a % 3].add(a);
        }

        if (n == lists[0].size()) {
            System.out.println(-1);
            return;
        }

        if (lists[0].isEmpty() && !lists[1].isEmpty() && !lists[2].isEmpty()) {
            System.out.println(-1);
            return;
        }

        if (lists[1].isEmpty() && lists[2].size() + 1 < lists[0].size()) {
            System.out.println(-1);
            return;
        }

        if (lists[2].isEmpty() && lists[1].size() + 1 < lists[0].size()) {
            System.out.println(-1);
            return;
        }

        if (lists[1].size() + lists[2].size() + 1 < lists[0].size()) {
            System.out.println(-1);
            return;
        }

        int[] ans = new int[2 * n + 1];
        Arrays.fill(ans, -1);
        int idx = 1;

        for (int i = 0; i < lists[1].size(); i++) {
            ans[idx] = lists[1].get(i);
            idx += 2;
        }

        if (!lists[0].isEmpty()) {
            ans[idx - 1] = lists[0].get(0);
        }

        for (int i = 0; i < lists[2].size(); i++) {
            ans[idx] = lists[2].get(i);
            idx += 2;
        }

        idx = 0;

        for (int i = 1; i < lists[0].size(); i++) {
            if (ans[idx] > -1) idx += 2;

            ans[idx] = lists[0].get(i);
            idx += 2;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2 * n + 1; i++) {
            if (ans[i] > -1) sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}