package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N의배수1_18790 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node[][] dp = new Node[n + 1][n];
        dp[0][0] = new Node(-1, null);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * n - 1; i++) {
            int a = Integer.parseInt(st.nextToken());

            int l = list.size();

            for (int j = 0; j < l; j++) {
                int[] p = list.get(j);

                int r = p[0] + 1, c = (p[1] + a) % n;

                if (dp[r][c] == null) {
                    dp[r][c] = new Node(a, dp[p[0]][p[1]]);
                    if (r < n) list.add(new int[]{r, c});
                }
            }
        }

        Node cur = dp[n][0];

        if (cur == null) {
            System.out.println(-1);
            return;
        }

        Node[] arr = new Node[n];

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = cur;
            cur = cur.before;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i].num).append(" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int num;
        Node before;

        public Node(int num, Node before) {
            this.num = num;
            this.before = before;
        }
    }
}