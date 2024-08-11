package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 북쪽나라의도로_1595 {
    static int n;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        adj = new List[10000];
        for (int i = 0; i < 10000; i++) adj[i] = new ArrayList<>();

        n = 1;

        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);

            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            adj[c1].add(new int[] {c2, d});
            adj[c2].add(new int[] {c1, d});

            n++;
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] far = findFarthest(0);
        int[] ans = findFarthest(far[0]);

        System.out.println(ans[1]);
    }

    static int[] findFarthest(int s) {

        Stack<int[]> stack = new Stack<>();

        int max = 0;
        int e = s;
        boolean[] v = new boolean[n];

        stack.push(new int[] {s, 0});
        v[s] = true;

        while (!stack.isEmpty()) {
            int[] now = stack.pop();

            if (max < now[1]) {
                max = now[1];
                e = now[0];
            }

            for (int[] next : adj[now[0]]) {
                if (v[next[0]]) continue;

                v[next[0]] = true;

                stack.push(new int[]{next[0], now[1] + next[1]});
            }
        }

        return new int[]{e, max};
    }
}